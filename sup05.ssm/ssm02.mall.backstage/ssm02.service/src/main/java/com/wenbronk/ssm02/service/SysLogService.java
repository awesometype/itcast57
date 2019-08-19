package com.wenbronk.ssm02.service;

import com.wenbronk.ssm02.domain.Syslog;

import java.util.List;

/**
 * itcast57.com.wenbronk.ssm02.service
 * wenbronk create at 2019/7/27 11:52
 */
public interface SysLogService {

    void save(Syslog syslog);

    List<Syslog> findAll();

}
