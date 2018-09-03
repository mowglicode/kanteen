package io.kanteen.service;

import java.util.Date;
import java.util.List;

public interface IDateService {
    List<String> getNextDates();
    Date eatableDay(Date date);
    List<String> getNextWeek();

}
