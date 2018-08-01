package io.kanteen.service;

import java.util.Date;
import java.util.List;

public interface IDateService {
    List<Date> getNextDates();
    Date eatableDay(Date date);
}
