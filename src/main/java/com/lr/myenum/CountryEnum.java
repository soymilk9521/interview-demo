package com.lr.myenum;

import lombok.Getter;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020-11-10 8:21
 */
public enum CountryEnum {
    ONE(1, "齐"),
    TWO(2, "楚"),
    THREE(3, "燕"),
    FOUR(4, "韩"),
    FIVE(5, "赵"),
    SIX(6, "魏");
    @Getter
    private Integer code;
    @Getter
    private String countryName;

    CountryEnum(Integer code, String countryName) {
        this.code = code;
        this.countryName = countryName;
    }

    public static CountryEnum getCountry(Integer code) {
        CountryEnum[] countries = CountryEnum.values();
        for (CountryEnum country: countries) {
            if (country.getCode() == code){
                return country;
            }
        }
        return null;
    }
}
