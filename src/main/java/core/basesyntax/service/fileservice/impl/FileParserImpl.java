package core.basesyntax.service.fileservice.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.fileservice.FileParser;
import java.util.ArrayList;
import java.util.List;

public class FileParserImpl implements FileParser {
    private static final String REPLACE_REGEX = "\\W";
    private static final String REPLACE_REGEX_AMOUNT = "[^0-9-]";
    private static final int ZERO_COLUMN_INDEX = 0;
    private static final int FIRST_COLUMN_INDEX = 1;
    private static final int SECOND_COLUMN_INDEX = 2;
    private static final String COLUMN_SEPARATOR = ",";
    private static final String EMPTY_STRING = "";

    @Override
    public List<FruitRecordDto> parser(List<String> lines) {
        List<FruitRecordDto> listOfLines = new ArrayList<>(lines.size());
        for (int i = 1; i < lines.size(); i++) {
            String[] singleLineList = lines.get(i).split(COLUMN_SEPARATOR);
            FruitRecordDto fruitRecordDto =
                    new FruitRecordDto(singleLineList[ZERO_COLUMN_INDEX]
                            .replaceAll(REPLACE_REGEX, EMPTY_STRING),
                            singleLineList[FIRST_COLUMN_INDEX]
                                    .replaceAll(REPLACE_REGEX, EMPTY_STRING),
                            Integer.parseInt(singleLineList[SECOND_COLUMN_INDEX]
                                    .replaceAll(REPLACE_REGEX_AMOUNT, EMPTY_STRING)));
            listOfLines.add(fruitRecordDto);
        }
        return listOfLines;
    }
}
