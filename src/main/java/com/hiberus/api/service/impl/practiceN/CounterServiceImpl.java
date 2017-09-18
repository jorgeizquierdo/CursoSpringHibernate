package com.hiberus.api.service.impl.practiceN;

import com.hiberus.api.service.CounterService;
import org.springframework.stereotype.Service;

/**
 * Created by Daniel on 15/06/2016.
 */
@Service("counterService")
public class CounterServiceImpl implements CounterService {

    private ThreadLocal<Integer> safeTimes = new ThreadLocal<>();
    private Integer unsafeTimes = 0;

    @Override
    public synchronized int addSafeTimes(int times) {

        if(this.safeTimes.get() == null) this.safeTimes.set(0);

        this.safeTimes.set((this.safeTimes.get() + times));

        return this.safeTimes.get();
    }

    @Override
    public synchronized int addUnsafeTimes(int times) {

        return this.unsafeTimes = (this.unsafeTimes + times);
    }

}