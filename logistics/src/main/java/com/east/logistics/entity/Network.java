package com.east.logistics.entity;

public class Network {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network.n_id
     *
     * @mbg.generated
     */
    private Integer nId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network.n_province
     *
     * @mbg.generated
     */
    private String nProvince;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network.n_city
     *
     * @mbg.generated
     */
    private String nCity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network.n_county
     *
     * @mbg.generated
     */
    private String nCounty;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network.n_address
     *
     * @mbg.generated
     */
    private String nAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network.n_in
     *
     * @mbg.generated
     */
    private Integer nIn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network.n_out
     *
     * @mbg.generated
     */
    private Integer nOut;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network.n_id
     *
     * @return the value of network.n_id
     *
     * @mbg.generated
     */
    public Integer getnId() {
        return nId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network.n_id
     *
     * @param nId the value for network.n_id
     *
     * @mbg.generated
     */
    public void setnId(Integer nId) {
        this.nId = nId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network.n_province
     *
     * @return the value of network.n_province
     *
     * @mbg.generated
     */
    public String getnProvince() {
        return nProvince;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network.n_province
     *
     * @param nProvince the value for network.n_province
     *
     * @mbg.generated
     */
    public void setnProvince(String nProvince) {
        this.nProvince = nProvince == null ? null : nProvince.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network.n_city
     *
     * @return the value of network.n_city
     *
     * @mbg.generated
     */
    public String getnCity() {
        return nCity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network.n_city
     *
     * @param nCity the value for network.n_city
     *
     * @mbg.generated
     */
    public void setnCity(String nCity) {
        this.nCity = nCity == null ? null : nCity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network.n_county
     *
     * @return the value of network.n_county
     *
     * @mbg.generated
     */
    public String getnCounty() {
        return nCounty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network.n_county
     *
     * @param nCounty the value for network.n_county
     *
     * @mbg.generated
     */
    public void setnCounty(String nCounty) {
        this.nCounty = nCounty == null ? null : nCounty.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network.n_address
     *
     * @return the value of network.n_address
     *
     * @mbg.generated
     */
    public String getnAddress() {
        return nAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network.n_address
     *
     * @param nAddress the value for network.n_address
     *
     * @mbg.generated
     */
    public void setnAddress(String nAddress) {
        this.nAddress = nAddress == null ? null : nAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network.n_in
     *
     * @return the value of network.n_in
     *
     * @mbg.generated
     */
    public Integer getnIn() {
        return nIn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network.n_in
     *
     * @param nIn the value for network.n_in
     *
     * @mbg.generated
     */
    public void setnIn(Integer nIn) {
        this.nIn = nIn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network.n_out
     *
     * @return the value of network.n_out
     *
     * @mbg.generated
     */
    public Integer getnOut() {
        return nOut;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network.n_out
     *
     * @param nOut the value for network.n_out
     *
     * @mbg.generated
     */
    public void setnOut(Integer nOut) {
        this.nOut = nOut;
    }
}