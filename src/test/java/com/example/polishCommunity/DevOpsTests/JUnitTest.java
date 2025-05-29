package com.example.polishCommunity.DevOpsTests;

import com.example.polishCommunity.DevOpsTestDTO;
import com.example.polishCommunity.model.Rights;
import com.example.polishCommunity.model.SubRights;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitTest {
    @Test
    public void DTOTest()  {
        Rights item = new Rights(1,"Domain 7: Rights and Responsibilities","In seeking to become a Nation of Sanctuary, as well as through implementing the Anti Racist Wales Action Plan, the Welsh Government is seeking to eliminate inequalities and support integration. For people to fully integrate with Welsh communities, they need to understand their rights and responsibilities. Host community members equally have responsibilities to follow the law, engage with democratic processes and participate in local communities. Individuals also need to be able to exercise their rights to ensure they have the safety net which is sometimes required. This is why advice services and awareness-raising activities can play a critical role in supporting integration. Awareness of rights and responsibilities will support new migrants to build social connections and awareness of Welsh systems more quickly. Rights and responsibilities establish a common framework for interactions between all individuals in a community. It is therefore important that new migrants are supported to understand these as soon as possible.\n\nAwareness of rights and responsibilities will support new migrants to build social connections and awareness of Welsh systems more quickly. Rights and responsibilities establish a common framework for interactions between all individuals in a community. It is therefore important that new migrants are supported to understand these as soon as possible.");
        assertEquals(item.getTitleId(), 1);
        assertEquals(item.getTitle(), "Domain 7: Rights and Responsibilities");
        assertEquals(item.getDescription(), "In seeking to become a Nation of Sanctuary, as well as through implementing the Anti Racist Wales Action Plan, the Welsh Government is seeking to eliminate inequalities and support integration. For people to fully integrate with Welsh communities, they need to understand their rights and responsibilities. Host community members equally have responsibilities to follow the law, engage with democratic processes and participate in local communities. Individuals also need to be able to exercise their rights to ensure they have the safety net which is sometimes required. This is why advice services and awareness-raising activities can play a critical role in supporting integration. Awareness of rights and responsibilities will support new migrants to build social connections and awareness of Welsh systems more quickly. Rights and responsibilities establish a common framework for interactions between all individuals in a community. It is therefore important that new migrants are supported to understand these as soon as possible.\n\nAwareness of rights and responsibilities will support new migrants to build social connections and awareness of Welsh systems more quickly. Rights and responsibilities establish a common framework for interactions between all individuals in a community. It is therefore important that new migrants are supported to understand these as soon as possible.");
    }

    @Test
    public void ModelTest()  {
        SubRights item = new SubRights(1,"Indicator 1: percent registering to vote","Does data exist for UK-born individuals in Wales? Yes: Electoral statistics for the UK. Does data exist for migrants in Wales? Yes: Overseas, anonymous, opted-out, EU citizens and Parliamentary electors by local authority.",1);
        assertEquals(item.getSubTitleId(), 1);
        assertEquals(item.getSubTitle(), "Indicator 1: percent registering to vote");
        assertEquals(item.getDescription(), "Does data exist for UK-born individuals in Wales? Yes: Electoral statistics for the UK. Does data exist for migrants in Wales? Yes: Overseas, anonymous, opted-out, EU citizens and Parliamentary electors by local authority.");
    }
}
