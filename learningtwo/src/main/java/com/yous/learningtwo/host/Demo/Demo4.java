package com.yous.learningtwo.host.Demo;

import com.yous.learningtwo.host.Person;
import com.yous.learningtwo.host.dto.Student;
import org.apache.commons.lang3.EnumUtils;

import java.lang.reflect.Method;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by syou on 2017/9/3.
 */
public class Demo4 {

    public static void main(String[] args) throws Exception {
        String a="aBcd";
        String b="abcD";
        System.out.println(a.equalsIgnoreCase(b));



        List<String> list = Arrays.asList(
                "唛斝","斝桫","桫掵","暭烎","掵岦","懗嵀","嵀妠","墿烎","墏堃","堃懗","烎暭","妠烎","岦懗","妠。","岦。","懗。",
                "戠。","懗戠","堃。","桫。","暭。","梌。","梌掵","掵。","欤。","掵欤","桫欤","唛。","唛懗","唛烎","岦唛","杶。",
                "杷。","杸。","杹。","杺。","杻。","杼。","杽。","枀。","枂。","枃。","枅。","枆。","枈。","枊。","枋。","枌。",
                "枍。","枎。","枑。","枒。","枓。","枔。","枖。","枘。","枙。","枛。","枞。","枟。","枠。","枡。","枤。","枥。",
                "枦。","枋枦","枈枋","析枋","枃烎","枒岦","杺懗","戠枒","掵枒","枖岦","枠岦","妠枠","枤枟","唛斝");


        System.out.println(list.stream().anyMatch(o->"枦。sa".contains(o)));

/*

        Time time=Time.valueOf("00:00:00");
        LocalTime time1=LocalTime.of(0,0,0);
        System.out.println(time.toLocalTime().compareTo(time1)==0);
        System.out.println(time1);
*/

        /*list2.forEach(x->{
            list.stream().filter(y->y.getId()==x.getId());
        });
*/
        //  list2.stream().max(Comparator.comparing(p->p.getId())).ifPresent(x->x.getId());

        //int  as= list4.stream().max(Comparator.comparing(p->p.getId())).orElseGet(null).getId().intValue();

        //  Optional.ofNullable(list4).map(x -> x.stream().filter(y -> y.getId() == 1).distinct().collect(Collectors.toList()).size();

       /* int speakerCount = Optional.ofNullable(list2).map(messages -> messages.stream()
                .filter(m ->m.getId()==1)
                .map(p->p.getId())
                .distinct().collect(Collectors.toList())
                .size()).orElse(0);*/

       /* int speakerCount4 = Optional.ofNullable(list2).map(messages -> messages.stream()
                .filter(m ->m.getId()==1)
                .map(p -> p.getName())
                .distinct().collect(Collectors.toList())
                .size()).orElse(0);*/

/*

        list4=Optional.ofNullable(list2).map(messages -> messages.stream()
                .max(Comparator.comparing(x->x.getId())).get().getId()
                ).;
*/

/*

        //去除list2中与list 不匹配的
        Optional.ofNullable(list).ifPresent(lt -> {
            list2.removeIf(l2 -> lt.stream().noneMatch(lt1 -> Objects.equals(lt1.getId(), l2.getId())));
        });
*/

        //  System.out.println(list2.size());
     /*  List<Integer> ids= Optional.ofNullable(list).map(t->t.stream().map(Student::getId).collect(Collectors.toList()))
              .map(idss::addAll)
              .orElse(null);*/

       /* List<Man> mans=new ArrayList<>();

        mans.add(new Man(1L,"hiehei"));
        mans.add(new Man(2L,"hiehei"));
        mans.add(new Man(4L,"sas"));

        list.forEach(s->{
            Man man=mans.stream().filter(x->x.getId().equals(s.getId())).findAny().orElse(null);
            if(man!=null){
                System.out.println(man.getName());
            }

        });*/

        //Integer a=new Integer(5);
       /* Long b=new Long(5);
        long c=5;
        boolean f=b.longValue()==a.intValue();
        */
        //System.out.println(a.equals(5));
/*
        Student student=new Student();
        String h="%s hhahaha";
        h=h.replace("%s",student.getName());
        System.out.println(h);*/

    }


    private static Enum getEnum(Class clazz, int val) throws Exception {
        List<Enum> enumConstants = EnumUtils.getEnumList(clazz);
        Method method1 = clazz.getMethod("getValue");
        Method method2 = clazz.getMethod("getDesc");
        for (Enum item : enumConstants) {

            if (method1.invoke(item).toString().equals(String.valueOf(val))) {
                return item;
            }
        }

        return null;
    }


}
