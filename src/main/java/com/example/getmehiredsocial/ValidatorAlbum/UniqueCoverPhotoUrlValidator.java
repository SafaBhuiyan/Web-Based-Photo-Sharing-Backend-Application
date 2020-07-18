package com.example.getmehiredsocial.ValidatorAlbum;
import com.example.getmehiredsocial.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCoverPhotoUrlValidator implements ConstraintValidator<UniqueCoverPhotoUrl,String> {

    @Autowired
    AlbumService albumService;
    @Override
    public void initialize(UniqueCoverPhotoUrl constraintAnnotation) {

    }

    @Override
    public boolean isValid(String coverPhotoUrl, ConstraintValidatorContext constraintValidatorContext) {
        return !albumService.coverPhotoUrlExists(coverPhotoUrl);
    }

    }

