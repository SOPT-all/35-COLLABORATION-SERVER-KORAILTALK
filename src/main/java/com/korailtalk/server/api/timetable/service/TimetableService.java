package com.korailtalk.server.api.timetable.service;

import com.korailtalk.server.api.common.enums.ErrorStatus;
import com.korailtalk.server.api.common.exception.NotFoundException;
import com.korailtalk.server.api.timetable.dto.response.TimetableResponse;
import com.korailtalk.server.api.timetable.dto.response.TimetablesResponse;
import com.korailtalk.server.db.timetable.entity.Timetable;
import com.korailtalk.server.db.timetable.repository.TimetableRepository;
import com.korailtalk.server.db.train.entity.Train;
import com.korailtalk.server.db.user.entity.User;
import com.korailtalk.server.db.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimetableService {

    private final TimetableRepository timetableRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true) // 항상 적어주는게 좋음
    public TimetablesResponse getAllTimetables(Long userId, String date, String departurePlace, String arrivalPlace) {
        //final List<Timetable> findTimetables = timetableRepository.findAllByDateAndDeparturePlaceAndArrivalPlace(date, departurePlace, arrivalPlace);

        return TimetablesResponse.of(getTimetableList(userId, date, departurePlace, arrivalPlace));
    }


    private List<TimetableResponse> getTimetableList(Long userId, String date, String departurePlace, String arrivalPlace) {

        final User findUser = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(ErrorStatus.NOT_FOUND_USER)
        );

        final List<Timetable> Timetables = timetableRepository.findByDateAndDeparturePlaceAndArrivalPlace(date, departurePlace, arrivalPlace);

        return Timetables.stream().map(
                timetable -> {
                    Train train = timetable.getTrain();
                    return TimetableResponse.builder()
                            .timetableId(timetable.getId())
                            .trainName(train.getName())
                            .departureTime(timetable.getDepartureAt())
                            .arrivalTime(timetable.getArrivalAt())
                            .standardPrice(timetable.getStandardPrice())
                            .premiumPrice(timetable.getPremiumPrice())
                            .isStandardSold(timetable.isStandardSold()) //boolean 타입일 땐 isStandardSold() 형태
                            .isPremiumSold(timetable.isPremiumSold())
                            .travelTime(timetable.getTravelTime())
                            .build();
                }
        ).toList();
    }
}
