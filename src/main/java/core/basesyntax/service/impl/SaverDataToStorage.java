package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.ApplierFruitsToStorage;
import java.util.List;
import java.util.Map;

public class SaverDataToStorage {

    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";

    public void saveDataToStorage(List<FruitRecordDto> fruitDtos,
                                  Map<OperationType, ApplierFruitsToStorage> operationStrategyMap) {
        for (FruitRecordDto fruitRecordDto : fruitDtos) {
            switch (fruitRecordDto.getOperationType()) {
                case (PURCHASE):
                    operationStrategyMap.get(OperationType.PURCHASE)
                            .applyFruitToStorage(fruitRecordDto);
                    break;
                case (BALANCE):
                    operationStrategyMap.get(OperationType.BALANCE)
                            .applyFruitToStorage(fruitRecordDto);
                    break;
                case (SUPPLY):
                    operationStrategyMap.get(OperationType.SUPPLY)
                            .applyFruitToStorage(fruitRecordDto);
                    break;
                case (RETURN):
                    operationStrategyMap.get(OperationType.RETURN)
                                .applyFruitToStorage(fruitRecordDto);
                    break;
                default:
                    throw new RuntimeException("No such operation allowed");
            }
        }

    }
}

