package ua.rakhmail.hw35.services;

import ua.rakhmail.hw35.objects.Statistic;
import ua.rakhmail.hw35.objects.Visit;

import java.util.concurrent.ConcurrentLinkedDeque;

public class VisitService {
    private static int count = 0;
    private final static ConcurrentLinkedDeque<Visit> visits = new ConcurrentLinkedDeque<>();
    private static VisitService singleton = null;

    private VisitService() {
    }

    private void incrementCounter() {
        ++count;
    }

    public static VisitService getSingleton() {
        if (singleton == null) {
            singleton = new VisitService();
        }
        return singleton;
    }


    public ConcurrentLinkedDeque<Visit> getVisits() {
        incrementCounter();
        return visits;
    }

    public synchronized void addVisit(Visit visit) {
        incrementCounter();
        visits.add(visit);

        if (visits.size() > 3) {
            visits.removeFirst();
        }
    }

    public Statistic getStats() {
        incrementCounter();
        return new Statistic(count);
    }
}
