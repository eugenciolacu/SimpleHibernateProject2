package com.hibernate.main;

import com.hibernate.dao.DanceDao;
import com.hibernate.dao.ManDao;
import com.hibernate.dao.WomanDao;
import com.hibernate.entity.Dance;
import com.hibernate.entity.Man;
import com.hibernate.entity.Woman;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class App
{
    public static void main( String[] args ) {

        ManDao md = new ManDao();
        WomanDao wd = new WomanDao();
        DanceDao dd = new DanceDao();

        Man man1 = new Man("Ion Ionovici");
        Man man2 = new Man("Misha Ghimpu");
        md.addMan(man1);
        md.addMan(man2);
        System.out.println(md.getById(man1.getId()));
        man1.setName("Ivan Ivanovici");
        md.editMan(man1);
        System.out.println(md.getById(man1.getId()));
        md.deleteMan(man1);
        md.printAll(md.getAll());


        Woman woman1 = new Woman("Megan Fox");
        Woman woman2 = new Woman("Alina Zotea");
        wd.addWoman(woman1);
        wd.addWoman(woman2);
        System.out.println(wd.getById(woman1.getId()));
        woman1.setName("Pamella Anderson");
        wd.editWoman(woman1);
        System.out.println(wd.getById(woman1.getId()));
        wd.deleteWoman(woman1);
        wd.printAll(wd.getAll());

        Dance dance1 = new Dance("German Heavy Metal", man2, woman2);
        Dance dance2 = new Dance("Canadian Pop-Rock", man2, woman2);
        dd.addDance(dance1);
        dd.addDance(dance2);
        System.out.println(dd.getById(dance1.getId()));
        dance1.setStyle("Classical Rock");
        dd.editDance(dance1);
        System.out.println(dd.getById(dance1.getId()));
        dd.deleteDance(dance1);
        dd.printAll(dd.getAll());
    }
}
