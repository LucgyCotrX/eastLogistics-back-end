package com.east.logistics.dao;

import com.east.logistics.entity.Network;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NetworkMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table network
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer nId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table network
     *
     * @mbg.generated
     */
    int insert(Network record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table network
     *
     * @mbg.generated
     */
    Network selectByPrimaryKey(Integer nId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table network
     *
     * @mbg.generated
     */
    List<Network> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table network
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Network record);

    int count();

    List<Network> selectVague(@Param("nProvince") String nProvince,@Param("nCity") String nCity,@Param("nCount") String nCounty,@Param("nAddress") String nAddress,@Param("nIn") Integer nIn,@Param("nOut") Integer nOut );

    int countVague(@Param("nProvince") String nProvince,@Param("nCity") String nCity,@Param("nCount") String nCounty,@Param("nAddress") String nAddress,@Param("nIn") Integer nIn,@Param("nOut") Integer nOut);
}