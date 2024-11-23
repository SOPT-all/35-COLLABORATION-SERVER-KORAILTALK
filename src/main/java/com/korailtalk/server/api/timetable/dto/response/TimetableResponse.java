package com.korailtalk.server.api.timetable.dto.response;

import lombok.Builder;

@Builder
public record TimetableResponse(
        Long timetableId,
        String trainName,
        String departureTime,
        String arrivalTime,
        int standardPrice,
        int premiumPrice,
        boolean isStandardSold,
        boolean isPremiumSold,
        int travelTime
) {

    public static TimetableResponse of(final Long timetableId,final String trainName, final String departureTime, final String arrivalTime, final int standardPrice, final int premiumPrice, final boolean isStandardSold, final boolean isPremiumSold, final int travelTime){
        return new TimetableResponse(timetableId, trainName, departureTime,arrivalTime, standardPrice, premiumPrice, isStandardSold, isPremiumSold, travelTime);
    }
}
