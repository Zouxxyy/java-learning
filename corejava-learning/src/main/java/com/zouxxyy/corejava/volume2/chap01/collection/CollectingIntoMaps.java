package com.zouxxyy.corejava.volume2.chap01.collection;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 程序1-5
 * 从流中将结果收集到映射表中
 * @version 1.00 2019-03-15
 * @author zouxxyy
 */
public class CollectingIntoMaps {
    public static class Person {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return getClass().getName() + "[id=" + id + ",name=" + name + "]";
        }
    }

    public static Stream<Person> people() {
        return Stream.of(new Person(1001, "Peter"), new Person(1002, "Paul"),
                new Person(1003, "Mary"));
    }

    public static void main(String[] args) throws IOException {
        Map<Integer, String> idToName = people().collect(
                Collectors.toMap(Person::getId, Person::getName));
        System.out.println("idToName: " + idToName);

        Map<Integer, Person> idToPerson = people().collect(
                Collectors.toMap(Person::getId, Function.identity()));
        System.out.println("idToPerson " + idToPerson.getClass() + idToPerson);

        idToPerson = people().collect(
                Collectors.toMap(Person::getId, Function.identity(), (existingValue, newValue) -> {
                    throw new IllegalStateException();
                    }, TreeMap::new));
        System.out.println("idToPerson " + idToPerson.getClass() + idToPerson);

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageNames = locales.collect(
                Collectors.toMap(Locale::getDisplayLanguage, l -> l.getDisplayLanguage(l),
                        (existingValue, newValue) -> existingValue));
        System.out.println("languageNames: " + languageNames);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryLanguageSets = locales.collect(
                Collectors.toMap(Locale::getDisplayCountry, l -> Collections.singleton(l.getDisplayLanguage()),
                        (a, b) -> {Set<String> union = new HashSet<>(a);
                                    union.addAll(b);
                                    return union; })); // 醉了
        System.out.println("countryLanguageSets: " + countryLanguageSets);

    }
}

/*
idToName: {1001=Peter, 1002=Paul, 1003=Mary}
idToPerson class java.util.HashMap{1001=com.zouxxyy.corejava.volume2.chap01.collection.CollectingIntoMaps$Person[id=1001,name=Peter], 1002=com.zouxxyy.corejava.volume2.chap01.collection.CollectingIntoMaps$Person[id=1002,name=Paul], 1003=com.zouxxyy.corejava.volume2.chap01.collection.CollectingIntoMaps$Person[id=1003,name=Mary]}
idToPerson class java.util.TreeMap{1001=com.zouxxyy.corejava.volume2.chap01.collection.CollectingIntoMaps$Person[id=1001,name=Peter], 1002=com.zouxxyy.corejava.volume2.chap01.collection.CollectingIntoMaps$Person[id=1002,name=Paul], 1003=com.zouxxyy.corejava.volume2.chap01.collection.CollectingIntoMaps$Person[id=1003,name=Mary]}
languageNames: {土耳其文=Türkçe, =, 意大利文=italiano, 冰岛文=íslenska, 印地文=हिंदी, 马其顿文=македонски, 乌克兰文=українська, 立陶宛文=Lietuvių, 越南文=Tiếng Việt, 俄文=русский, 爱沙尼亚文=Eesti, 日文=日本語, 瑞典文=svenska, 希伯来文=עברית, 加泰罗尼亚文=català, 斯洛伐克文=Slovenčina, 爱尔兰文=Gaeilge, 泰文=ไทย, 波兰文=polski, 罗马尼亚文=română, 西班牙文=español, 朝鲜文=한국어, 法文=français, 丹麦文=Dansk, 马耳他文=Malti, 英文=English, 拉托维亚文(列托)=Latviešu, 塞尔维亚文=Српски, 保加利亚文=български, 阿拉伯文=العربية, 白俄罗斯文=беларускі, 捷克文=čeština, 斯洛文尼亚文=Slovenščina, 挪威文=norsk, 中文=中文, 克罗地亚文=hrvatski, 芬兰文=suomi, 希腊文=Ελληνικά, 荷兰文=Nederlands, 匈牙利文=magyar, 德文=Deutsch, 葡萄牙文=português, 印度尼西亚文=Bahasa Indonesia, 阿尔巴尼亚文=shqip, 马来文=Bahasa Melayu}
countryLanguageSets: {泰国=[泰文], 巴西=[葡萄牙文], =[, 土耳其文, 意大利文, 冰岛文, 印地文, 乌克兰文, 马其顿文, 立陶宛文, 越南文, 俄文, 爱沙尼亚文, 日文, 瑞典文, 斯洛伐克文, 加泰罗尼亚文, 希伯来文, 爱尔兰文, 泰文, 波兰文, 西班牙文, 罗马尼亚文, 朝鲜文, 法文, 丹麦文, 马耳他文, 英文, 拉托维亚文(列托), 塞尔维亚文, 保加利亚文, 阿拉伯文, 捷克文, 白俄罗斯文, 斯洛文尼亚文, 挪威文, 中文, 克罗地亚文, 芬兰文, 希腊文, 匈牙利文, 荷兰文, 葡萄牙文, 德文, 印度尼西亚文, 阿尔巴尼亚文, 马来文], 塞尔维亚及黑山=[塞尔维亚文], 丹麦=[丹麦文], 塞尔维亚=[塞尔维亚文], 委内瑞拉=[西班牙文], 克罗地亚=[克罗地亚文], 新西兰=[英文], 阿曼=[阿拉伯文], 约旦=[阿拉伯文], 卢森堡=[德文, 法文], 巴拉圭=[西班牙文], 波斯尼亚和黑山共和国=[塞尔维亚文], 洪都拉斯=[西班牙文], 伊拉克=[阿拉伯文], 古巴=[西班牙文], 挪威=[挪威文], 萨尔瓦多=[西班牙文], 黎巴嫩=[阿拉伯文], 阿根廷=[西班牙文], 越南=[越南文], 哥斯达黎加=[西班牙文], 美国=[英文, 西班牙文], 罗马尼亚=[罗马尼亚文], 卡塔尔=[阿拉伯文], 香港=[中文], 沙特阿拉伯=[阿拉伯文], 秘鲁=[西班牙文], 韩国=[朝鲜文], 尼加拉瓜=[西班牙文], 巴林=[阿拉伯文], 厄瓜多尔=[西班牙文], 哥伦比亚=[西班牙文], 玻利维亚=[西班牙文], 阿拉伯联合酋长国=[阿拉伯文], 巴拿马=[西班牙文], 德国=[德文], 马其顿王国=[马其顿文], 立陶宛=[立陶宛文], 波多黎哥=[西班牙文], 以色列=[希伯来文], 墨西哥=[西班牙文], 危地马拉=[西班牙文], 希腊=[希腊文, 德文], 保加利亚=[保加利亚文], 捷克共和国=[捷克文], 英国=[英文], 印度=[印地文, 英文], 马耳他=[马耳他文, 英文], 匈牙利=[匈牙利文], 塞浦路斯=[希腊文], 波兰=[波兰文], 瑞士=[意大利文, 德文, 法文], 奥地利=[德文], 法国=[法文], 意大利=[意大利文], 俄罗斯=[俄文], 白俄罗斯=[白俄罗斯文], 荷兰=[荷兰文], 台湾地区=[中文], 斯洛文尼亚=[斯洛文尼亚文], 黑山=[塞尔维亚文], 土耳其=[土耳其文], 芬兰=[芬兰文], 瑞典=[瑞典文], 摩洛哥=[阿拉伯文], 西班牙=[加泰罗尼亚文, 西班牙文], 苏丹=[阿拉伯文], 斯洛伐克=[斯洛伐克文], 阿尔及利亚=[阿拉伯文], 比利时=[荷兰文, 法文], 冰岛=[冰岛文], 乌克兰=[乌克兰文], 乌拉圭=[西班牙文], 智利=[西班牙文], 突尼斯=[阿拉伯文], 也门=[阿拉伯文], 加拿大=[英文, 法文], 日本=[日文], 南非=[英文], 爱沙尼亚=[爱沙尼亚文], 埃及=[阿拉伯文], 利比亚=[阿拉伯文], 叙利亚=[阿拉伯文], 拉脱维亚=[拉托维亚文(列托)], 马来西亚=[马来文], 多米尼加共和国=[西班牙文], 爱尔兰=[爱尔兰文, 英文], 葡萄牙=[葡萄牙文], 中国=[中文], 阿尔巴尼亚=[阿尔巴尼亚文], 新加坡=[中文, 英文], 澳大利亚=[英文], 印度尼西亚=[印度尼西亚文], 科威特=[阿拉伯文], 菲律宾=[英文]}
 */
