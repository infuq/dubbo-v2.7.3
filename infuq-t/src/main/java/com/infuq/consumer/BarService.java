package com.infuq.consumer;

import com.infuq.provider.Computer;

public interface BarService {

    String query(String bookName);

    Computer listComputer();

}
