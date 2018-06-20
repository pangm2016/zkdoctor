package com.ucar.zkdoctor.dao.mysql;

import com.ucar.zkdoctor.pojo.bo.MachineSearchBO;
import com.ucar.zkdoctor.pojo.po.MachineInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description: 机器信息Dao
 * Created on 2018/1/9 11:06
 *
 * @author 吕小玲(xiaoling.lv@ucarinc.com)
 */
public interface MachineInfoDao {

    /**
     * 保存新机器信息
     *
     * @param machineInfo 机器信息
     * @return
     */
    boolean insertMachine(MachineInfo machineInfo);

    /**
     * 通过机器id获取机器信息
     *
     * @param id 机器id
     * @return
     */
    MachineInfo getMachineInfoById(int id);

    /**
     * 通过机器ip获取机器信息
     *
     * @param host 机器ip
     * @return
     */
    MachineInfo getMachineInfoByHost(String host);

    /**
     * 通过机器名称获取机器信息
     *
     * @param hostName 机器名称
     * @return
     */
    MachineInfo getMachineInfoByHostName(String hostName);


    /**
     * 通过机器域名获取机器信息
     *
     * @param hostDomain 机器域名
     * @return
     */
    MachineInfo getMachineInfoByDomain(String hostDomain);

    /**
     * 获取所有可用状态的机器列表
     *
     * @return
     */
    List<MachineInfo> getAllAvailableMachineInfos();

    /**
     * 获取所有机器信息
     *
     * @return
     */
    List<MachineInfo> getAllMachineInfos();

    /**
     * 根据查询条件获取机器信息
     *
     * @param machineSearchBO 查询条件
     * @return
     */
    List<MachineInfo> getAllMachinesByParams(MachineSearchBO machineSearchBO);

    /**
     * 获取某集群下的所有机器信息
     *
     * @param clusterId 集群id
     * @return
     */
    List<MachineInfo> getMachineInfoByClusterId(int clusterId);

    /**
     * 更新机器信息
     *
     * @param machineInfo
     * @return
     */
    boolean updateMachineInfo(MachineInfo machineInfo);

    /**
     * 更新机器是否可用
     *
     * @param id        机器id
     * @param available 机器是否可用
     * @return
     */
    boolean updateMachineAvailable(@Param("id") int id, @Param("available") boolean available);

    /**
     * 删除某机器信息
     *
     * @param id 机器id
     * @return
     */
    boolean deleteMachineInfoById(int id);

    /**
     * 获取所有监控中的机器列表信息
     *
     * @return
     */
    List<MachineInfo> getAllMonitorMachine();

    /**
     * 修改机器监控开关
     *
     * @param id      机器id
     * @param monitor 是否监控
     * @return
     */
    boolean updateMachineMonitor(@Param("id") int id, @Param("monitor") boolean monitor);
}
