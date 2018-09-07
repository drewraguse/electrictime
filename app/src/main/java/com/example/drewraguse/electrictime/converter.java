package com.example.drewraguse.electrictime;

public class converter {

    public static double walk_miles(int miles) {
        return (miles*60)/3.1;
    }



    public static double boosted_miles(int miles) {
        return (miles*60)/18;
    }

    public static double evolve_miles(int miles) {
        return (miles*60)/26;
    }

    public static double segway_miles(int miles) {
        return (miles*60)/12.5;
    }

    public static double hoverboard_miles(int miles) {
        return (miles*60)/8;
    }

    public static int max_mins(int mins) {
        if (mins > 300) {
            return 50;
        } else {
            return mins/6;
        }
    }

    public static double edit_value(int val, String spin) {
        if (spin.equals("Walking")) {
            return 60*val/3.1;
        } else if (spin.equals("Boosted Mini S Board")) {
            return 60*val/18;
        } else if (spin.equals("Evolve Skateboard")) {
            return 60*val/26;
        } else if (spin.equals("Segway i2 SE")) {
            return 60*val/12.5;
        } else {
            return 60*val/8;
        }

    }
}
