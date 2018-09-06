package io.kanteen.service.impl;

import io.kanteen.service.IDateService;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DateService implements IDateService {


    private static long DAY_IN_MS = 1000 * 60 * 60 * 25;
    @Override
    public List<String> getNextDates() {
        int number = 5;
        Date now = new Date();
        int deadline = 1;

        List<Date> result = new ArrayList<>();
        Date current = new Date(now.getTime() + (deadline+1) * DAY_IN_MS);
        current = eatableDay(current);
        result.add(current);
        while (result.size() < number) {
            current = new Date(current.getTime()+DAY_IN_MS);
            current = eatableDay(current);
            result.add(current);
        }
        //convert date to string
        DateFormat df = new SimpleDateFormat("EEE dd-MM-aa");
        List<String> resultString = new ArrayList<>();
        for (Date d: result){
            String s = df.format(d);
            resultString.add(s);
        }
        return resultString;
    }

    @Override
    public Date eatableDay(Date date){
        Calendar gregor = Calendar.getInstance();
        gregor.setTime(date);

        switch (gregor.get(Calendar.DAY_OF_WEEK)){
            case Calendar.WEDNESDAY:
                return new Date(date.getTime()+DAY_IN_MS);
            case Calendar.SATURDAY:
                return new Date(date.getTime()+2*DAY_IN_MS);
            case Calendar.SUNDAY:
                return new Date(date.getTime()+DAY_IN_MS);

            default:
                return date;
        }
    }

    @Override
    public List<String> getNextWeek() {
        int number = 6;
        Date now = new Date();

        List<Date> result = new ArrayList<>();
        Date current = new Date(now.getTime());
        current = eatableDay(current);
        result.add(current);
        while (result.size() < number) {
            current = new Date(current.getTime()+DAY_IN_MS);
            current = eatableDay(current);
            result.add(current);
        }
        //convert date to string
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        List<String> resultString = new ArrayList<>();
        for (Date d: result){
            String s = df.format(d);
            resultString.add(s);
        }
        return resultString;
    }



}
