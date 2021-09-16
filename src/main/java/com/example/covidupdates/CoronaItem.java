package com.example.covidupdates;

public class CoronaItem {

    private String LastUpdated;
    private String Death;
    private String TodayDeath;
    private String ActiveCases;
    private String TodayConfirmedCases;
    private String RecoveredCases;
    private String TodayRecoveredCases;
    private String ConfirmedCases;
    private String State;


    public CoronaItem(String lastUpdated, String death, String todayDeath, String activeCases, String todayconfirmedcases, String recoveredCases, String todayRecoveredCases, String confirmedCases, String state) {
        LastUpdated = lastUpdated;
        Death = death;
        TodayDeath = todayDeath;
        ActiveCases = activeCases;
        TodayConfirmedCases = todayconfirmedcases;
        RecoveredCases = recoveredCases;
        TodayRecoveredCases = todayRecoveredCases;
        ConfirmedCases = confirmedCases;
        State = state;
    }


    public String getLastUpdated() {
        return LastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        LastUpdated = lastUpdated;
    }

    public String getDeath() {
        return Death;
    }

    public void setDeath(String death) {
        Death = death;
    }

    public String getTodayDeath() {
        return TodayDeath;
    }

    public void setTodayDeath(String todayDeath) {
        TodayDeath = todayDeath;
    }

    public String getActiveCases() {
        return ActiveCases;
    }

    public void setActiveCases(String activeCases) {
        ActiveCases = activeCases;
    }

    public String getTodayConfirmedCases() { return TodayConfirmedCases;
    }

    public void setTodayActiveCases(String todayActiveCases) {
        TodayConfirmedCases = TodayConfirmedCases;
    }

    public String getRecoveredCases() {
        return RecoveredCases;
    }

    public void setRecoveredCases(String recoveredCases) {
        RecoveredCases = recoveredCases;
    }

    public String getTodayRecoveredCases() {
        return TodayRecoveredCases;
    }

    public void setTodayRecoveredCases(String todayRecoveredCases) {
        TodayRecoveredCases = todayRecoveredCases;
    }

    public String getConfirmedCases() {
        return ConfirmedCases;
    }

    public void setConfirmedCases(String confirmedCases) {
        ConfirmedCases = confirmedCases;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}
