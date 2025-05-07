package org._jd;

import org._jd.UI.UI;
import org._jd.UI.UIImpl;

public class Main {
    public static void main(String[] args) {

        UI ui = new UIImpl(61);

        ui.init();
        ui.menu();

    }

}