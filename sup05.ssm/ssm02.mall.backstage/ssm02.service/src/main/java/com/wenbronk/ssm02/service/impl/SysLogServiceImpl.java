package com.wenbronk.ssm02.service.impl;

import com.wenbronk.ssm02.dao.LogDao;
import com.wenbronk.ssm02.domain.Syslog;
import com.wenbronk.ssm02.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * itcast57.com.wenbronk.ssm02.service.impl
 * wenbronk create at 2019/7/27 11:52
 */
@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private LogDao logDao;

    @Override
    public void save(Syslog syslog) {
        logDao.save(syslog);
    }

    @Override
    public List<Syslog> findAll() {
        return logDao.findAll();
    }
}
