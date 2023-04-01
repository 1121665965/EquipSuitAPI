package com.equipsuit.equip_suit_v1.api.modInterfcae.player;

import com.equipsuit.equip_suit_v1.common.container.SuitContainer;

import java.util.ArrayList;
import java.util.HashMap;


public interface IPlayerInterface {
    ArrayList<int[]> getSuitList();
    Integer getFocus();
    void setFocus(Integer integer);
    void updateFocus();
    boolean setSuitArray(int num, int... ints);
    SuitContainer getSuitContainer();
}
