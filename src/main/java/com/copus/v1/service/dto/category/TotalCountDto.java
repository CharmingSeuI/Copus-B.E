package com.copus.v1.service.dto.category;

import com.copus.v1.service.dto.search.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalCountDto {

    private int totalCount;
    private int bookNameCount;
    private int authorNameCount;
<<<<<<< HEAD
=======
    private int gwonchaCount;
    private int muncheCount;
    private int finalTitleeCount;
>>>>>>> Feature_Category
    private int contentCount;

}
