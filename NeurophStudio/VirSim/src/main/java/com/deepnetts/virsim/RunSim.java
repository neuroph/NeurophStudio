package com.deepnetts.virsim;

public class RunSim {
    public static void main(String[] args) {
        
        int day = 0;
        
        int initallyInffected = 0;
        // koliko ih dolazi avionom i koja distribucija
        
        // https://covid19.rs/%d1%81%d1%82%d0%b0%d1%82%d0%b8%d1%81%d1%82%d0%b8%d1%87%d0%ba%d0%b8-%d0%bf%d0%be%d0%b4%d0%b0%d1%86%d0%b8-%d0%be-%d0%ba%d0%be%d1%80%d0%be%d0%bd%d0%b0%d0%b2%d0%b8%d1%80%d1%83%d1%81%d1%83/
        
        Region serbia = new Region("Srbija", 6982604);     
        serbia.addSubRegion("Beograd", 1233796, 1035) // 1192
              .addSubRegion("Novi Sad", 277522, 129) // 2,151
              .addSubRegion("Niš", 187544, 266) // 705
              .addSubRegion("Čačak", 73331, 636) // 115
              .addSubRegion("Ćuprija", 19471, 287); // 67
        
//              .addSubRegion("Valjevo", 1000000)
//              .addSubRegion("Kruševac", 1000000)
//              .addSubRegion("Leskovac", 1000000)
//              .addSubRegion("Zaječar", 1000000)
//              .addSubRegion("Pirot", 1000000)
//              .addSubRegion("Vranje", 1000000)
//              .addSubRegion("Subotica", 1000000)
//              .addSubRegion("Zaječar", 1000000)
//              .addSubRegion("Kraljevo", 1000000)
//              .addSubRegion("Kragujevac", 1000000)
//              .addSubRegion("Ćuprija", 50000)
//              .addSubRegion("Novi Pazar", 50000);
        
        // ubaci inficirane
        
        // svakog dana jedan inficirani zarazi jos nekoliko u zavisnosti od mera - verovatnoca da ce nekoga zaraziti
        // ozdravi ili umre nekoliko ljudi u zavisnosti od broja ustanova, medicinskih radnika i raspolozivih resursa
        // period inkubacije 13-30 dana

        //ekonomija, snabdevanje
        // javno mnjenje
        // mediji
        // koliko ce da doputuje, i koliko ce biti zarazeno
        // nulti pacijent od koga je pocela zaraza
        
        while(day<1000) {
            day++;            
            spreadInfections(serbia);
            cure(serbia);
            die(serbia);
        }
    }

    private static void spreadInfections(Region region) {
       // svaki zarazeni zarazi po jos nekoliko u zavisnsoti od mera i drugih parametara
       // koji parametri uticu na brzinu sirenja infekcije, verovatnocu zaraze
       // uradi za sve podregione
    }

    private static void cure(Region region) {
        // za nekoliko nedelja jedan broj ozdravi u skladu sa verovatnocom
        // koji parametri uticu na ozdravljenje
        // age
    }

    private static void die(Region region) {
        // za odredjeni perod nekoliko umre u zavisnosti od verovatnoce
        // koji parametri uticu na smrtnost: age, 
    }
}
