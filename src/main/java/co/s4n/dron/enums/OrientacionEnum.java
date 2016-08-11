package co.s4n.dron.enums;

import org.apache.commons.lang.WordUtils;

/**
 * Created by fawkes on 8/11/16.
 */
public enum OrientacionEnum {
    NORTE, SUR,ORIENTE ,OCCIDENTE;

    @Override
    public String toString() {

        return WordUtils.capitalize(super.toString().toLowerCase());
    }
}
