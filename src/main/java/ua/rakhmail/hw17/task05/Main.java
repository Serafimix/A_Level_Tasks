package ua.rakhmail.hw17.task05;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Box> boxes = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            boxes.add(new Box());
        }
        Box.printFilterColl(boxes);
    }
}

//        [Item(name=Item7, cost=528), Item(name=Item8, cost=789), Item(name=Item1, cost=1717),
//        Item(name=Item6, cost=2038), Item(name=Item5, cost=3965), Item(name=Item9, cost=4194),
//        Item(name=Item10, cost=6434), Item(name=Item4, cost=7107), Item(name=Item3, cost=7484), Item(name=Item2, cost=8400)]
//
//        [Item(name=Item17, cost=616), Item(name=Item13, cost=1449), Item(name=Item20, cost=2054),
//        Item(name=Item11, cost=5541), Item(name=Item12, cost=6924), Item(name=Item14, cost=6929),
//        Item(name=Item19, cost=8457), Item(name=Item15, cost=8614), Item(name=Item18, cost=9792), Item(name=Item16, cost=9904)]
//
//        [Item(name=Item47, cost=184), Item(name=Item46, cost=839), Item(name=Item42, cost=1848),
//        Item(name=Item41, cost=2658), Item(name=Item40, cost=2850), Item(name=Item45, cost=2859),
//        Item(name=Item43, cost=3545), Item(name=Item44, cost=5570), Item(name=Item38, cost=5757), Item(name=Item39, cost=9157)]
//
//        [Item(name=Item68, cost=2040), Item(name=Item70, cost=2437), Item(name=Item66, cost=2461),
//        Item(name=Item69, cost=3203), Item(name=Item67, cost=4172), Item(name=Item62, cost=4658),
//        Item(name=Item64, cost=4931), Item(name=Item63, cost=5355), Item(name=Item65, cost=8496), Item(name=Item61, cost=8925)]