package com.example.polishCommunity.service;

import com.example.polishCommunity.model.Rights;
import com.example.polishCommunity.model.SubRights;
import com.example.polishCommunity.repository.RightsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RightsService {
    private RightsRepo rightsRepo;
    public RightsService(RightsRepo rightsRepo){
        this.rightsRepo=rightsRepo;
 }
        public Rights getRightsByTitleId(int id){
            Rights rights=null;
        try {
            rights = rightsRepo.getRightsById(id);
            if (rightsRepo.getSubRightsByRightsId(id) != null) {
                rights.setSubTitle(rightsRepo.getSubRightsByRightsId(id));
            } else {
                throw new NullPointerException("List of Sub Rights cannot be empty");
            }
            rights.setQue(rightsRepo.getRightsFAQsByRightsId(id));

            }
        catch (NullPointerException exception){
            System.out.println(exception.getMessage());
            }
        catch (Exception exception){
            System.out.println("Unexpected occurred");
            }
        return rights;
        }
//         public void setRights(int id, String subTitle, String description){
//            rightsRepo.addSubRightsByRightsId(id,subTitle, description);
//         }

        public void setRights(SubRights subRights){
            rightsRepo.addSubRight(subRights);
        }
        public void deleteSubRights(int id){
            rightsRepo.deleteSubRights(id);
        }

        public SubRights getSubRightsBySubRightsId(int id){
            return rightsRepo.getSubRightsBySubRightsId(id);
        }

    public void editSubRight(SubRights subRights) {
        rightsRepo.editSubRight(subRights);
    }


}
