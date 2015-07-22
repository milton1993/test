package com.mitong.test.guava.functional;

import com.google.common.base.*;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Map;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-22
 */
public class FunctionsTest {private  String format = "dd/mm/yyyy";
    private  String mapString = "foo=bar,red=white,moe=larry";
    private Map<String,String> testMap;
    private Map<String,State> stateMap = Maps.newHashMap();
    private City city;
    private State state;
    private City city1;
    private State state1;
    private State defaultState;

    public void setUp(){
        testMap = Splitter.on(',').withKeyValueSeparator('=').split(mapString);
        city = new City("Austin,TX","12345",250000, Climate.SUB_TROPICAL,45.3);
        state = new State("Texas","TX", Sets.newHashSet(city), Region.SOUTHWEST);
        city1 = new City("Austin,TX","12345",250000, Climate.SUB_TROPICAL,45.3);
        state1 = new State("Texas","BJ", Sets.newHashSet(city), Region.SOUTHWEST);
        defaultState = new State("No State","XX",new HashSet<City>(),Region.NO_REGION);
        stateMap.put(state.getCode(), state);
        stateMap.put(state1.getCode(), state1);
    }

    public static void main(String[] args) {
        FunctionsTest functionsTest = new FunctionsTest();
        functionsTest.setUp();
        Function<String,State> stateMapFunction = Functions.forMap(functionsTest.stateMap);
        System.out.println(stateMapFunction.apply("TX").equals(functionsTest.state));
        System.out.println(functionsTest.stateMap.get("TX").equals(functionsTest.state));

        Function<State, String> stateStringFunction = new Function<State, String>() {
            @Override
            public String apply(State state) {
                return Joiner.on(",").join(state.getMainCities());
            }
        };
        Function<String, String> composed = Functions.compose(stateStringFunction, stateMapFunction);
        System.out.println(composed.apply("TX"));
    }
}
