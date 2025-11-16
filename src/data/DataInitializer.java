package data;

import factory.NewsFactory;

public class DataInitializer {
    public static void initialize(NewsStorage storage, NewsFactory factory) {
        storage.add(factory.create("SPORT", "Mbappé hat-trick", "Mbappé scored three goals leading PSG to 3-1 victory."));
        storage.add(factory.create("SPORT", "Kazakhstan volleyball wins", "Kazakhstan beat Uzbekistan 3-0 in qualifiers."));
        storage.add(factory.create("SPORT", "Hamilton wins Monaco", "Lewis Hamilton won the Monaco Grand Prix."));
        storage.add(factory.create("SPORT", "Bayern clinches title", "Bayern Munich secures another Bundesliga trophy."));
        storage.add(factory.create("SPORT", "Djokovic triumph", "Djokovic wins a Grand Slam title."));
        storage.add(factory.create("SPORT", "Almaty Lions", "Almaty Lions win national basketball final."));
        storage.add(factory.create("SPORT", "Swimming record", "New world record in 100m freestyle."));
        storage.add(factory.create("SPORT", "Local derby", "Derby ended 2-2 with dramatic finish."));
        storage.add(factory.create("SPORT", "Golovkin KO", "Golovkin returned with a knockout win."));
        storage.add(factory.create("SPORT", "Youth stars emerge", "Several academy players impressed scouts."));

        storage.add(factory.create("POLITICS", "US elections update", "Major campaign announcement shakes political world."));
        storage.add(factory.create("POLITICS", "UN climate resolution", "UN approves stronger climate measures."));
        storage.add(factory.create("POLITICS", "Peace talks progress", "Negotiators report tentative progress."));
        storage.add(factory.create("POLITICS", "New prime minister", "Parliament confirmed a new PM."));
        storage.add(factory.create("POLITICS", "Trade deal signed", "Two countries sign a new trade deal."));
        storage.add(factory.create("POLITICS", "Local reforms", "Government proposes electoral reforms."));
        storage.add(factory.create("POLITICS", "Sanctions updated", "New sanctions target key sectors."));
        storage.add(factory.create("POLITICS", "Summit on security", "Regional summit focuses on security."));
        storage.add(factory.create("POLITICS", "City protests", "Large demonstrations call for reforms."));
        storage.add(factory.create("POLITICS", "Diplomatic visit", "High-level diplomatic exchange under way."));

        storage.add(factory.create("MAIN", "Startup secures funding", "Local startup secures major investment."));
        storage.add(factory.create("MAIN", "Smartphone released", "Leading brand releases new flagship phone."));
        storage.add(factory.create("MAIN", "Metro expansion", "City begins new metro construction."));
        storage.add(factory.create("MAIN", "Healthcare AI", "Hospitals adopt AI-assisted diagnostics."));
        storage.add(factory.create("MAIN", "Education program", "Digital learning initiative launched."));
        storage.add(factory.create("MAIN", "Economic growth", "Reports show steady GDP increase."));
        storage.add(factory.create("MAIN", "Cultural festival", "Festival features films and music."));
        storage.add(factory.create("MAIN", "Green investments", "Major investments in renewables announced."));
        storage.add(factory.create("MAIN", "Local market grows", "Small businesses report improved sales."));
        storage.add(factory.create("MAIN", "Art exhibition", "International exhibition draws crowds."));
    }
}
