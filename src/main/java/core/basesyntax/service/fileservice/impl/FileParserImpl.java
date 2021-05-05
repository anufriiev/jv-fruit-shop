package core.basesyntax.service.fileservice.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.fileservice.FileParser;
import java.util.ArrayList;
import java.util.List;

public class FileParserImpl implements FileParser {
    private static final String REPLACE_REGEX = "\\W";
    private static final String REPLACE_REGEX_AMOUNT = "[^0-9-]";
    private static final int FIRST_ELEMENT = 0;
    private static final int SECOND_ELEMENT = 1;
    private static final int THIRD_ELEMENT = 2;
    private static final String COMA = ",";
    private static final String EMPTY_STRING = "";

    @Override
    public List<FruitRecordDto> parser(List<String> lines) {
        List<FruitRecordDto> listOfLines = new ArrayList<>(lines.size());
        for (int i = 0; i < lines.size(); i++) {
            String[] singleLineList = lines.get(i).split(COMA);
            FruitRecordDto fruitRecordDto =
                    new FruitRecordDto(singleLineList[FIRST_ELEMENT]
                            .replaceAll(REPLACE_REGEX, EMPTY_STRING),
                            new Fruit(singleLineList[SECOND_ELEMENT]
                                    .replaceAll(REPLACE_REGEX, EMPTY_STRING)),
                            Integer.parseInt(singleLineList[THIRD_ELEMENT]
                                    .replaceAll(REPLACE_REGEX_AMOUNT, EMPTY_STRING)));
            listOfLines.add(fruitRecordDto);
        }
        return listOfLines;
    }
}
