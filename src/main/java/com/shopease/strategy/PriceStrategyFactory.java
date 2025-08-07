package com.shopease.strategy;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PriceStrategyFactory {

    private final Map<String, PriceStrategy> strategyMap = new HashMap<>();
    
    public PriceStrategyFactory(List<PriceStrategy> strategies) {
        // Registrar todas las estrategias disponibles por nombre de tipo
        for (PriceStrategy strategy : strategies) {
            String key = extractType(strategy); // Puedes definir una convención aquí
            strategyMap.put(key, strategy);
        }
    }

    public PriceStrategy getStrategy(String storeType) {
        return strategyMap.getOrDefault(storeType.toUpperCase(), new BasicStoreStrategy());
    }

    private String extractType(PriceStrategy strategy) {
        if (strategy instanceof PremiumStoreStrategy) return "PREMIUM";
        if (strategy instanceof PartnerStoreStrategy) return "PARTNER";
        return "BASIC"; // Default
    }
}
