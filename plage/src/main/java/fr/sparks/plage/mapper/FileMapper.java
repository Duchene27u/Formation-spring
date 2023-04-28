package fr.sparks.plage.mapper;

import fr.sparks.plage.dto.FileDto;
import fr.sparks.plage.entity.File;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FileMapper {

    File fileDtoToFile(FileDto fileDto);

    FileDto fileToFileDto(File file);
}
