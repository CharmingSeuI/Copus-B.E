package com.copus.v1.service.show;

//저자 정보

import com.copus.v1.domain.info.meta.Author;
import com.copus.v1.repository.info.meta.AuthorRepository;
import com.copus.v1.service.ConsonantRangeSet;
import com.copus.v1.service.dto.show.ShowAuthorNameDto;
import com.copus.v1.service.dto.show.ShowLv4Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShowAuthorName implements ConsonantRangeSet {

    public final AuthorRepository authorRepository;

    //Lv1 서지명 입력, Id 반환

    public ArrayList<ShowAuthorNameDto> showAuthorNameByConsonant(String consonant){

        ArrayList<ShowAuthorNameDto> showAuthorNameDtoList = new ArrayList<>();

        String consonant1 = ConsonantRangeSet.consonantRange(consonant).get(0);
        String consonant2 = ConsonantRangeSet.consonantRange(consonant).get(1);

        List<Author> authorList=authorRepository.findAuthorNameByConsonant(consonant1, consonant2);

        ShowAuthorNameDto showAuthorNameDto = new ShowAuthorNameDto();

        for(Author author : authorList){
            showAuthorNameDto.setAuthorKor(author.getNameKor());
            showAuthorNameDto.setAuthorChn(author.getNameChn());
            showAuthorNameDto.setAuthorKorChn(author.getNameKor()+"("+author.getNameChn()+")");

            showAuthorNameDtoList.add(showAuthorNameDto);
        }

        return showAuthorNameDtoList;
    }


}
