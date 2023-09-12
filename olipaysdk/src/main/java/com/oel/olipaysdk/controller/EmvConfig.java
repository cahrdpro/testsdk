package com.oel.olipaysdk.controller;

import android.util.Log;

import com.oel.olipaysdk.utils.StringUtils;
import com.urovo.i9000s.api.emv.ContantPara;
import com.urovo.i9000s.api.emv.EmvNfcKernelApi;
import com.urovo.i9000s.api.emv.ContantPara.Operation;
import java.util.Hashtable;

class EmvConfig {


    private final EmvNfcKernelApi emvApi;
    private boolean debugModeEnabled = false;

    public static final int CONTACTLESS_NO_CVM_AMOUNT = 400;

    public static final int CONTACTLESS_MAX_AMOUNT = 100000;

    EmvConfig(EmvNfcKernelApi emvApi) {
        this.emvApi = emvApi;
    }

    protected void setDebugModeEnabled(boolean debugModeEnabled) {
        this.debugModeEnabled = debugModeEnabled;
    }

    private void addCAPK_emvL2_visa57() {
        Hashtable<String, String> capk = new Hashtable();
        //capk.location = "30";
        capk.put("Rid", "A000000003");
        capk.put("Index", "57");
        capk.put("Exponent", "010001");
        //capk.size = "07C0";
        capk.put("Modulus", "942B7F2BA5EA307312B63DF77C5243618ACC2002BD7ECB74D821FE7BDC78BF28F49F74190AD9B23B9713B140FFEC1FB429D93F56BDC7ADE4AC075D75532C1E590B21874C7952F29B8C0F0C1CE3AEEDC8DA25343123E71DCF86C6998E15F756E3");
        capk.put("Checksum", "429C954A3859CEF91295F663C963E582ED6EB253");
        emvApi.updateCAPK(ContantPara.Operation.ADD, capk);
    }

    private void addCAPK_ADVT_92() {
        Hashtable<String, String> capk = new Hashtable();
        //capk.location = "30";
        capk.put("Rid", "A000000003");
        capk.put("Index", "92");
        capk.put("Exponent", "03");
        //capk.size = "07C0";
        capk.put("Modulus", "996AF56F569187D09293C14810450ED8EE3357397B18A2458EFAA92DA3B6DF6514EC060195318FD43BE9B8F0CC669E3F844057CBDDF8BDA191BB64473BC8DC9A730DB8F6B4EDE3924186FFD9B8C7735789C23A36BA0B8AF65372EB57EA5D89E7D14E9C7B6B557460F10885DA16AC923F15AF3758F0F03EBD3C5C2C949CBA306DB44E6A2C076C5F67E281D7EF56785DC4D75945E491F01918800A9E2DC66F60080566CE0DAF8D17EAD46AD8E30A247C9F");
        capk.put("Checksum", "429C954A3859CEF91295F663C963E582ED6EB253");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    private void addCAPK_ADVT_94() {
        Hashtable<String, String> capk = new Hashtable();

        capk.put("Rid", "A000000003");
        capk.put("Index", "94");
        capk.put("Exponent", "03");

        capk.put("Modulus", "ACD2B12302EE644F3F835ABD1FC7A6F62CCE48FFEC622AA8EF062BEF6FB8BA8BC68BBF6AB5870EED579BC3973E121303D34841A796D6DCBC41DBF9E52C4609795C0CCF7EE86FA1D5CB041071ED2C51D2202F63F1156C58A92D38BC60BDF424E1776E2BC9648078A03B36FB554375FC53D57C73F5160EA59F3AFC5398EC7B67758D65C9BFF7828B6B82D4BE124A416AB7301914311EA462C19F771F31B3B57336000DFF732D3B83DE07052D730354D297BEC72871DCCF0E193F171ABA27EE464C6A97690943D59BDABB2A27EB71CEEBDAFA1176046478FD62FEC452D5CA393296530AA3F41927ADFE434A2DF2AE3054F8840657A26E0FC617");
        capk.put("Checksum", "C4A3C43CCF87327D136B804160E47D43B60E6E0F");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    /**
     * Added after contacting support, fixes issue with HSBC or other card transaction getting terminated
     */
    private void addCapk_visa_05() {
        Hashtable<String, String> capk = new Hashtable();

        capk.put("Rid", "A000000003");
        capk.put("Index", "05");
        capk.put("Exponent", "03");

        capk.put("Modulus", "D0135CE8A4436C7F9D5CC66547E30EA402F98105B71722E24BC08DCC80AB7E71EC23B8CE6A1DC6AC2A8CF55543D74A8AE7B388F9B174B7F0D756C22CBB5974F9016A56B601CCA64C71F04B78E86C501B193A5556D5389ECE4DEA258AB97F52A3");
        capk.put("Checksum", "00000000000000000000000000000000000000");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    /**
     * Added after contacting support, fixes issue with HSBC or other card transaction getting terminated
     */
    private void addCapk_visa_08() {
        Hashtable<String, String> capk = new Hashtable();

        capk.put("Rid", "A000000003");
        capk.put("Index", "08");
        capk.put("Exponent", "03");

        capk.put("Modulus", "D9FD6ED75D51D0E30664BD157023EAA1FFA871E4DA65672B863D255E81E137A51DE4F72BCC9E44ACE12127F87E263D3AF9DD9CF35CA4A7B01E907000BA85D24954C2FCA3074825DDD4C0C8F186CB020F683E02F2DEAD3969133F06F7845166ACEB57CA0FC2603445469811D293BFEFBAFAB57631B3DD91E796BF850A25012F1AE38F05AA5C4D6D03B1DC2E568612785938BBC9B3CD3A910C1DA55A5A9218ACE0F7A21287752682F15832A678D6E1ED0B");
        capk.put("Checksum", "00000000000000000000000000000000000000");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    /**
     * Added after contacting support, fixes issue with HSBC or other card transaction getting terminated
     */
    private void addCapk_visa_09() {
        Hashtable<String, String> capk = new Hashtable();

        capk.put("Rid", "A000000003");
        capk.put("Index", "09");
        capk.put("Exponent", "03");

        capk.put("Modulus", "9D912248DE0A4E39C1A7DDE3F6D2588992C1A4095AFBD1824D1BA74847F2BC4926D2EFD904B4B54954CD189A54C5D1179654F8F9B0D2AB5F0357EB642FEDA95D3912C6576945FAB897E7062CAA44A4AA06B8FE6E3DBA18AF6AE3738E30429EE9BE03427C9D64F695FA8CAB4BFE376853EA34AD1D76BFCAD15908C077FFE6DC5521ECEF5D278A96E26F57359FFAEDA19434B937F1AD999DC5C41EB11935B44C18100E857F431A4A5A6BB65114F174C2D7B59FDF237D6BB1DD0916E644D709DED56481477C75D95CDD68254615F7740EC07F330AC5D67BCD75BF23D28A140826C026DBDE971A37CD3EF9B8DF644AC385010501EFC6509D7A41");
        capk.put("Checksum", "00000000000000000000000000000000000000");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    private void addCAPK_mast_F1() {
        Hashtable<String, String> capk = new Hashtable();

        capk.put("Rid", "A000000004");
        capk.put("Index", "F1");
        capk.put("Exponent", "03");

        capk.put("Modulus", "A0DCF4BDE19C3546B4B6F0414D174DDE294AABBB828C5A834D73AAE27C99B0B053A90278007239B6459FF0BBCD7B4B9C6C50AC02CE91368DA1BD21AAEADBC65347337D89B68F5C99A09D05BE02DD1F8C5BA20E2F13FB2A27C41D3F85CAD5CF6668E75851EC66EDBF98851FD4E42C44C1D59F5984703B27D5B9F21B8FA0D93279FBBF69E090642909C9EA27F898959541AA6757F5F624104F6E1D3A9532F2A6E51515AEAD1B43B3D7835088A2FAFA7BE7");
        capk.put("Checksum", "D8E68DA167AB5A85D8C3D55ECB9B0517A1A5B4BB");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    private void addCAPK_mast_F8() {
        Hashtable<String, String> capk = new Hashtable();

        capk.put("Rid", "A000000004");
        capk.put("Index", "F8");
        capk.put("Exponent", "03");

        capk.put("Modulus", "A1F5E1C9BD8650BD43AB6EE56B891EF7459C0A24FA84F9127D1A6C79D4930F6DB1852E2510F18B61CD354DB83A356BD190B88AB8DF04284D02A4204A7B6CB7C5551977A9B36379CA3DE1A08E69F301C95CC1C20506959275F41723DD5D2925290579E5A95B0DF6323FC8E9273D6F849198C4996209166D9BFC973C361CC826E1");
        capk.put("Checksum", "00000000000000000000000000000000000000");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    private void addCAPK_mast_real_04() {
        Hashtable<String, String> capk = new Hashtable();

        capk.put("Rid", "A000000004");
        capk.put("Index", "04");
        capk.put("Exponent", "03");

        capk.put("Modulus", "A6DA428387A502D7DDFB7A74D3F412BE762627197B25435B7A81716A700157DDD06F7CC99D6CA28C2470527E2C03616B9C59217357C2674F583B3BA5C7DCF2838692D023E3562420B4615C439CA97C44DC9A249CFCE7B3BFB22F68228C3AF13329AA4A613CF8DD853502373D62E49AB256D2BC17120E54AEDCED6D96A4287ACC5C04677D4A5A320DB8BEE2F775E5FEC5");
        capk.put("Checksum", "00000000000000000000000000000000000000");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    private void addCAPK_mast_real_05() {
        Hashtable<String, String> capk = new Hashtable();

        capk.put("Rid", "A000000004");
        capk.put("Index", "05");
        capk.put("Exponent", "03");

        capk.put("Modulus", "B8048ABC30C90D976336543E3FD7091C8FE4800DF820ED55E7E94813ED00555B573FECA3D84AF6131A651D66CFF4284FB13B635EDD0EE40176D8BF04B7FD1C7BACF9AC7327DFAA8AA72D10DB3B8E70B2DDD811CB4196525EA386ACC33C0D9D4575916469C4E4F53E8E1C912CC618CB22DDE7C3568E90022E6BBA770202E4522A2DD623D180E215BD1D1507FE3DC90CA310D27B3EFCCD8F83DE3052CAD1E48938C68D095AAC91B5F37E28BB49EC7ED597");
        capk.put("Checksum", "00000000000000000000000000000000000000");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    /**
     * Added after contacting support
     */
    private void addCAPK_mast_real_06() {
        Hashtable<String, String> capk = new Hashtable();
        capk.put("Rid", "A000000004");
        capk.put("Index", "06");
        capk.put("Exponent", "03");
        capk.put("Modulus", "CB26FC830B43785B2BCE37C81ED334622F9622F4C89AAE641046B2353433883F307FB7C974162DA72F7A4EC75D9D657336865B8D3023D3D645667625C9A07A6B7A137CF0C64198AE38FC238006FB2603F41F4F3BB9DA1347270F2F5D8C606E420958C5F7D50A71DE30142F70DE468889B5E3A08695B938A50FC980393A9CBCE44AD2D64F630BB33AD3F5F5FD495D31F37818C1D94071342E07F1BEC2194F6035BA5DED3936500EB82DFDA6E8AFB655B1EF3D0D7EBF86B66DD9F29F6B1D324FE8B26CE38AB2013DD13F611E7A594D675C4432350EA244CC34F3873CBA06592987A1D7E852ADC22EF5A2EE28132031E48F74037E3B34AB747F");
        capk.put("Checksum", "F910A1504D5FFB793D94F3B500765E1ABCAD72D9");
        emvApi.updateCAPK(Operation.ADD, capk);
    }


    /**
     * Amex prod
     */
    private void addCAPK_amex_A000000025_index_10_exponent_03_PROD() {
        Hashtable<String, String> capk = new Hashtable();
        capk.put("Rid", "A000000025");
        capk.put("Index", "10");
        capk.put("Exponent", "03");
        capk.put("Modulus", "CF98DFEDB3D3727965EE7797723355E0751C81D2D3DF4D18EBAB9FB9D49F38C8C4A826B99DC9DEA3F01043D4BF22AC3550E2962A59639B1332156422F788B9C16D40135EFD1BA94147750575E636B6EBC618734C91C1D1BF3EDC2A46A43901668E0FFC136774080E888044F6A1E65DC9AAA8928DACBEB0DB55EA3514686C6A732CEF55EE27CF877F110652694A0E3484C855D882AE191674E25C296205BBB599455176FDD7BBC549F27BA5FE35336F7E29E68D783973199436633C67EE5A680F05160ED12D1665EC83D1997F10FD05BBDBF9433E8F797AEE3E9F02A34228ACE927ABE62B8B9281AD08D3DF5C7379685045D7BA5FCDE58637");
        capk.put("Checksum", "C729CF2FD262394ABC4CC173506502446AA9B9FD");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    /**
     *  Amex prod
     */
    private void addCAPK_amex_A000000025_index_0F_exponent_03_PROD() {
        Hashtable<String, String> capk = new Hashtable();
        capk.put("Rid", "A000000025");
        capk.put("Index", "0F");
        capk.put("Exponent", "03");
        capk.put("Modulus", "C8D5AC27A5E1FB89978C7C6479AF993AB3800EB243996FBB2AE26B67B23AC482C4B746005A51AFA7D2D83E894F591A2357B30F85B85627FF15DA12290F70F05766552BA11AD34B7109FA49DE29DCB0109670875A17EA95549E92347B948AA1F045756DE56B707E3863E59A6CBE99C1272EF65FB66CBB4CFF070F36029DD76218B21242645B51CA752AF37E70BE1A84FF31079DC0048E928883EC4FADD497A719385C2BBBEBC5A66AA5E5655D18034EC5");
        capk.put("Checksum", "A73472B3AB557493A9BC2179CC8014053B12BAB4");
        emvApi.updateCAPK(Operation.ADD, capk);
    }


    /**
     * Amex test card needed for certification, do not use in production
     */
    private void addCAPK_amex_A000000025_index_C1_exponent_03_TEST() {
        Hashtable<String, String> capk = new Hashtable();
        capk.put("Rid", "A000000025");
        capk.put("Index", "C1");
        capk.put("Exponent", "03");
        capk.put("Modulus", "E69E319C34D1B4FB43AED4BD8BBA6F7A8B763F2F6EE5DDF7C92579A984F89C4A9C15B27037764C58AC7E45EFBC34E138E56BA38F76E803129A8DDEB5E1CC8C6B30CF634A9C9C1224BF1F0A9A18D79ED41EBCF1BE78087AE8B7D2F896B1DE8B7E784161A138A0F2169AD33E146D1B16AB595F9D7D98BE671062D217F44EB68C68640C7D57465A063F6BAC776D3E2DAC61");
        capk.put("Checksum", "DC79D6B5FC879362299BC5A637DAD2E0D99656B8");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    /**
     * Amex test card needed for certification, do not use in production
     */
    private void addCAPK_amex_A000000025_index_C2_exponent_03_TEST() {
        Hashtable<String, String> capk = new Hashtable();
        capk.put("Rid", "A000000025");
        capk.put("Index", "C2");
        capk.put("Exponent", "03");
        capk.put("Modulus", "B875002F38BA26D61167C5D440367604AD38DF2E93D8EE8DA0E8D9C0CF4CC5788D11DEA689E5F41D23A3DA3E0B1FA5875AE25620F5A6BCCEE098C1B35C691889D7D0EF670EB8312E7123FCC5DC7D2F0719CC80E1A93017F944D097330EDF945762FEE62B7B0BA0348228DBF38D4216E5A67A7EF74F5D3111C44AA31320F623CB3C53E60966D6920067C9E082B746117E48E4F00E110950CA54DA3E38E5453BD5544E3A6760E3A6A42766AD2284E0C9AF");
        capk.put("Checksum", "8E748296359A7428F536ADDA8E2C037E2B697EF6");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    /**
     * Amex test card needed for certification, do not use in production
     */
    private void addCAPK_amex_A000000025_index_C3_exponent_03_TEST() {
        Hashtable<String, String> capk = new Hashtable();
        capk.put("Rid", "A000000025");
        capk.put("Index", "C3");
        capk.put("Exponent", "03");
        capk.put("Modulus", "B93182ABE343DFBF388C71C4D6747DCDEC60367FE63CFAA942D7D323E688D0832836548BF0EDFF1EDEEB882C75099FF81A93FA525C32425B36023EA02A8899B9BF7D7934E86F997891823006CEAA93091A73C1FDE18ABD4F87A22308640C064C8C027685F1B2DB7B741B67AB0DE05E870481C5F972508C17F57E4F833D63220F6EA2CFBB878728AA5887DE407D10C6B8F58D46779ECEC1E2155487D52C78A5C03897F2BB580E0A2BBDE8EA2E1C18F6AAF3EB3D04C3477DEAB88F150C8810FD1EF8EB0596866336FE2C1FBC6BEC22B4FE5D885647726DB59709A505F75C49E0D8D71BF51E4181212BE2142AB2A1E8C0D3B7136CD7B7708E4D");
        capk.put("Checksum", "12F1790CB0273DC73C6E70784BC24C12E8DB71F6");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    /**
     * Amex test card needed for certification, do not use in production
     */
    private void addCAPK_amex_A000000025_index_C7_exponent_03_TEST() {
        Hashtable<String, String> capk = new Hashtable();
        capk.put("Rid", "A000000025");
        capk.put("Index", "C7");
        capk.put("Exponent", "03");
        capk.put("Modulus", "CD237E34E0299DE48F1A2C94F478FE972896011E1CA6AB462B68FE0F6109C9A97C2DBEEA65932CDE0625138B9F162B92979DAAB019D3B5561D31EB2D4F09F12F927EA8F740CE0E87154965505E2272F69042B15D57CCC7F771919123978283B3CCE524D9715207BF5F5AD369102176F0F7A78A6DEB2BFF0EDCE165F3B14F14D0035B2756861FE03C43396ED002C894A3");
        capk.put("Checksum", "6221E0C726BAC8F8AC25F8F93B811D1FFD4C131C");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    /**
     * Amex test card needed for certification, do not use in production
     */
    private void addCAPK_amex_A000000025_index_C8_exponent_03_TEST() {
        Hashtable<String, String> capk = new Hashtable();
        capk.put("Rid", "A000000025");
        capk.put("Index", "C8");
        capk.put("Exponent", "03");
        capk.put("Modulus", "BF0CFCED708FB6B048E3014336EA24AA007D7967B8AA4E613D26D015C4FE7805D9DB131CED0D2A8ED504C3B5CCD48C33199E5A5BF644DA043B54DBF60276F05B1750FAB39098C7511D04BABC649482DDCF7CC42C8C435BAB8DD0EB1A620C31111D1AAAF9AF6571EEBD4CF5A08496D57E7ABDBB5180E0A42DA869AB95FB620EFF2641C3702AF3BE0B0C138EAEF202E21D");
        capk.put("Checksum", "33BD7A059FAB094939B90A8F35845C9DC779BD50");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    /**
     * Amex test card needed for certification, do not use in production
     */
    private void addCAPK_amex_A000000025_index_C9_exponent_03_TEST() {
        Hashtable<String, String> capk = new Hashtable();
        capk.put("Rid", "A000000025");
        capk.put("Index", "C9");
        capk.put("Exponent", "03");
        capk.put("Modulus", "B362DB5733C15B8797B8ECEE55CB1A371F760E0BEDD3715BB270424FD4EA26062C38C3F4AAA3732A83D36EA8E9602F6683EECC6BAFF63DD2D49014BDE4D6D603CD744206B05B4BAD0C64C63AB3976B5C8CAAF8539549F5921C0B700D5B0F83C4E7E946068BAAAB5463544DB18C63801118F2182EFCC8A1E85E53C2A7AE839A5C6A3CABE73762B70D170AB64AFC6CA482944902611FB0061E09A67ACB77E493D998A0CCF93D81A4F6C0DC6B7DF22E62DB");
        capk.put("Checksum", "8E8DFF443D78CD91DE88821D70C98F0638E51E49");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    /**
     * Amex test card needed for certification, do not use in production
     */
    private void addCAPK_amex_A000000025_index_CA_exponent_03_TEST() {
        Hashtable<String, String> capk = new Hashtable();
        capk.put("Rid", "A000000025");
        capk.put("Index", "CA");
        capk.put("Exponent", "03");
        capk.put("Modulus", "C23ECBD7119F479C2EE546C123A585D697A7D10B55C2D28BEF0D299C01DC65420A03FE5227ECDECB8025FBC86EEBC1935298C1753AB849936749719591758C315FA150400789BB14FADD6EAE2AD617DA38163199D1BAD5D3F8F6A7A20AEF420ADFE2404D30B219359C6A4952565CCCA6F11EC5BE564B49B0EA5BF5B3DC8C5C6401208D0029C3957A8C5922CBDE39D3A564C6DEBB6BD2AEF91FC27BB3D3892BEB9646DCE2E1EF8581EFFA712158AAEC541C0BBB4B3E279D7DA54E45A0ACC3570E712C9F7CDF985CFAFD382AE13A3B214A9E8E1E71AB1EA707895112ABC3A97D0FCB0AE2EE5C85492B6CFD54885CDD6337E895CC70FB3255E3");
        capk.put("Checksum", "6BDA32B1AA171444C7E8F88075A74FBFE845765F");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    private void addCapk_jcb_0F() {

        //
        //
        Hashtable<String, String> capk = new Hashtable();

        capk.put("Rid", "A000000065");
        capk.put("Index", "0F");
        capk.put("Exponent", "03");

        capk.put("Modulus", "9EFBADDE4071D4EF98C969EB32AF854864602E515D6501FDE576B310964A4F7C2CE842ABEFAFC5DC9E26A619BCF2614FE07375B9249BEFA09CFEE70232E75FFD647571280C76FFCA87511AD255B98A6B577591AF01D003BD6BF7E1FCE4DFD20D0D0297ED5ECA25DE261F37EFE9E175FB5F12D2503D8CFB060A63138511FE0E125CF3A643AFD7D66DCF9682BD246DDEA1");
        capk.put("Checksum", "00000000000000000000000000000000000000");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    private void addCapk_jcb_11() {

        //
        //
        Hashtable<String, String> capk = new Hashtable();

        capk.put("Rid", "A000000065");
        capk.put("Index", "11");
        capk.put("Exponent", "03");

        capk.put("Modulus", "A2583AA40746E3A63C22478F576D1EFC5FB046135A6FC739E82B55035F71B09BEB566EDB9968DD649B94B6DEDC033899884E908C27BE1CD291E5436F762553297763DAA3B890D778C0F01E3344CECDFB3BA70D7E055B8C760D0179A403D6B55F2B3B083912B183ADB7927441BED3395A199EEFE0DEBD1F5FC3264033DA856F4A8B93916885BD42F9C1F456AAB8CFA83AC574833EB5E87BB9D4C006A4B5346BD9E17E139AB6552D9C58BC041195336485");
        capk.put("Checksum", "00000000000000000000000000000000000000");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    private void addCapk_jcb_13() {

        //
        //
        Hashtable<String, String> capk = new Hashtable();

        capk.put("Rid", "A000000065");
        capk.put("Index", "13");
        capk.put("Exponent", "03");

        capk.put("Modulus", "A3270868367E6E29349FC2743EE545AC53BD3029782488997650108524FD051E3B6EACA6A9A6C1441D28889A5F46413C8F62F3645AAEB30A1521EEF41FD4F3445BFA1AB29F9AC1A74D9A16B93293296CB09162B149BAC22F88AD8F322D684D6B49A12413FC1B6AC70EDEDB18EC1585519A89B50B3D03E14063C2CA58B7C2BA7FB22799A33BCDE6AFCBEB4A7D64911D08D18C47F9BD14A9FAD8805A15DE5A38945A97919B7AB88EFA11A88C0CD92C6EE7DC352AB0746ABF13585913C8A4E04464B77909C6BD94341A8976C4769EA6C0D30A60F4EE8FA19E767B170DF4FA80312DBA61DB645D5D1560873E2674E1F620083F30180BD96CA589");
        capk.put("Checksum", "00000000000000000000000000000000000000");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    private void addAid_VisaElectron() {

        if (debugModeEnabled) Log.d("Qpay", "addAid_VisaElectron");
        Hashtable<String, String> data = new Hashtable<String, String>();
        data.put("CardType", "IcCard");//Note: UPI contactless AID use the CardType is IcCard
        data.put("aid", "A0000000032010");
        data.put("appVersion", "008C");
        data.put("terminalFloorLimit", "00000000");
        data.put("contactTACDefault", "DC4000A800");
        data.put("contactTACDenial", "0010000000");
        data.put("contactTACOnline", "DC4004F800");
        data.put("defaultDDOL", "9F3704");
        emvApi.updateAID(Operation.ADD, data);
    }

    private void addAid_MasterCard_Maestro_Amex_Jcb__Cirrus() {

        if (debugModeEnabled) Log.d("Qpay", "addAid_MasterCard_Maestro_Amex_Jcb__Cirrus");

        Hashtable<String, String> data = new Hashtable<String, String>();
        data.put("CardType", "IcCard");//Note: UPI contactless AID use the CardType is IcCard
        data.put("aid", "A0000000041010");
        data.put("appVersion", "0002");
        data.put("terminalFloorLimit", "00000000");
        data.put("contactTACDefault", "0000000000");
        data.put("contactTACDenial", "0000000000");
        data.put("contactTACOnline", "0000000000");
        data.put("AcquirerIdentifier", "112233");  // 9f01

        data.put("defaultDDOL", "9F3704");

        // A0000000043060D0562222
        emvApi.updateAID(Operation.ADD, data);

        data.put("aid", "A0000000043060");
        emvApi.updateAID(Operation.ADD, data); //Maestro

        data.put("aid", "A00000002501"); //amex
        data.put("appVersion", "0001");
        data.put("terminalFloorLimit", "00000000");
        data.put("contactTACDefault", "DC00FC9800");
        data.put("contactTACDenial", "0010000000");
        data.put("contactTACOnline", "DE00FC9800");

        data.put("defaultDDOL", "9F3704");
        emvApi.updateAID(Operation.ADD, data);

        data.put("appVersion", "0001");
        data.put("terminalFloorLimit", "00000000");
        data.put("contactTACDefault", "FC6024A800");
        data.put("contactTACDenial", "0010000000");
        //data.put("contactTACOnline", "FC60ACF800");
        data.put("contactTACOnline", "0000000000");

        data.put("defaultDDOL", "9F3704");
        data.put("aid", "A0000000651010");  //jcb
        emvApi.updateAID(Operation.ADD, data);

        data.put("aid", "A0000000046000");  //Cirrus
        emvApi.updateAID(Operation.ADD, data);
        /*
        data.put("aid", "A0000000043060D0561111");
        emvApi.updateAID(Operation.ADD, data);//A0000000046000`
        data.put("aid", "A0000000043060D0562222");
        emvApi.updateAID(Operation.ADD, data);//A0000000046000
        data.put("aid", "A0000000046000");
        emvApi.updateAID(Operation.ADD, data);//*/

    }

    private void addAid_Visa() {

        if (debugModeEnabled) Log.d("Qpay", "addAid_Visa");

        Hashtable<String, String> data = new Hashtable<String, String>();
        data.put("CardType", "IcCard");//Note: UPI contactless AID use the CardType is IcCard
        data.put("aid", "A0000000031010");
        data.put("appVersion", "0096");  // 008C
        data.put("terminalFloorLimit", "00000000");  // 100000 for test 20190929
        data.put("contactTACDefault", "DC4000A800");
        data.put("contactTACDenial", "0010000000");
        data.put("contactTACOnline", "DC4004F800");

        //data.put("defaultTDOL", "F850A8F800");
        data.put("defaultDDOL", "9F3704");
        emvApi.updateAID(Operation.ADD, data);

        data.put("aid", "A000000003101001");
        emvApi.updateAID(Operation.ADD, data);
        data.put("aid", "A000000003101002");
        emvApi.updateAID(Operation.ADD, data);
        data.put("aid", "A000000003101003");
        emvApi.updateAID(Operation.ADD, data);
        data.put("aid", "A000000003101004");
        emvApi.updateAID(Operation.ADD, data);
        data.put("aid", "A000000003101005");
        emvApi.updateAID(Operation.ADD, data);
        data.put("aid", "A0000003330101");//uninpay
        emvApi.updateAID(Operation.ADD, data);

    }

    private void addAid_DinersClubDiscover() {

        if (debugModeEnabled) Log.d("Qpay", "addAid_DinersClubDiscover");
        Hashtable<String, String> data = new Hashtable<String, String>();
        data.put("CardType", "IcCard");//Note: UPI contactless AID use the CardType is IcCard
        data.put("aid", "A0000001523010");  // Diners Club/Discover  //add by max 20191213
        data.put("appVersion", "0002");
        data.put("terminalFloorLimit", "00000000");
        data.put("contactTACDefault", "0000000000");
        data.put("contactTACDenial", "0000000000");
        data.put("contactTACOnline", "0000000000");
        data.put("AcquirerIdentifier", "112233");  // 9f01
        data.put("defaultDDOL", "9F3704");
        emvApi.updateAID(Operation.ADD, data);
    }

    private void addAid_Carnet() {

        if (debugModeEnabled) Log.d("Qpay", "addAid_Carnet");
        Hashtable<String, String> data = new Hashtable<String, String>();
        data.put("CardType", "IcCard");//Note: UPI contactless AID use the CardType is IcCard
        data.put("aid", "A000000724");
        data.put("appVersion", "0001");
        data.put("terminalFloorLimit", "00000000");
        data.put("contactTACDefault", "DC4000A800");
        data.put("contactTACDenial", "0010000000");
        data.put("contactTACOnline", "DC4004F800");
        data.put("defaultDDOL", "9F3704");
        emvApi.updateAID(Operation.ADD, data);
        data.put("aid", "A0000007241010");
        emvApi.updateAID(Operation.ADD, data);
        data.put("aid", "A0000007242010");
        emvApi.updateAID(Operation.ADD, data);
    }

    private void addCapk_carnet_01() { // Added after certification remark
        Hashtable<String, String> capk = new Hashtable();
        capk.put("Rid", "A000000724");
        capk.put("Index", "01");
        capk.put("Exponent", "03");
        capk.put("Modulus", "AE0B89755F0509F111FDF7CDBABE0491A2E3A6A778A0FCB1744C5445749FE9407E5BDE86D402DC63BAE999BD6698132181BE2AAD0B96C9BEBA11A521B165165AA40057292F79F7329724D178AF18FC342BB8B58D1DD84FF44847056BF17F66307500228558D847678F9FA462E290F3DFD898F11381BA1710B94D42F160780D0F60A909516653978AE750568B3960071092633530C053FFB7097EFBF140AFCB196861A0DA94ECDAC8D336BE97B8E9AFB7");
        capk.put("Checksum", "602A4CAB6084C493F01B29AB41F3140B85EABBEF");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    private void addCapk_carnet_02() { // Added after certification remark
        Hashtable<String, String> capk = new Hashtable();
        capk.put("Rid", "A000000724");
        capk.put("Index", "02");
        capk.put("Exponent", "03");
        capk.put("Modulus", "AABB504E3B2CC61F243A6BE3BFB18B649E17ED625F1F8EE04704873AD60564B22A1B0258EA1D25BA7A19F53D59E5FC60E85CE1535F99774ACA94A636F430F0A0E7E98BD5738475C66EBFED3FF4220EF8347D203BF3640714D47132AAC8276145DBA29A055CFE1476CF8CB0AD90A4FFA76F58A8CD2433B802829CD7E49AB10123B83E8BA1E90D556607DF128F7342467230E30B8C347137CD106E212D30E9BD5867D7232B425B3F644F02D71FED7A3C3CCA67BE4C04BC711C4B32DF8F7194765C65566B2E27CB86DEB49EA0E2F65B80D54DBE923C421027413BAA3B93517EE08631D58D00098BA22372921321C40CC5115346587ED436A181");
        capk.put("Checksum", "15C48DAD19DB502AB397647A38A0755E0FD0CB39");
        emvApi.updateCAPK(Operation.ADD, capk);
    }

    void initAID_CAPK() {

        addCAPK_ADVT_92();
        addCAPK_ADVT_94();
        addCAPK_mast_F1();
        addCAPK_mast_F8();

        addCAPK_mast_real_04();// add by ldp 20191128
        addCAPK_mast_real_05();
        addCAPK_mast_real_06();
        addCapk_visa_05(); // Added after contacting support, fixes issue with HSBC or other card transaction getting terminated
        addCapk_visa_08(); // Added after contacting support, fixes issue with HSBC or other card transaction getting terminated
        addCapk_visa_09(); // Added after contacting support, fixes issue with HSBC or other card transaction getting terminated

        addCAPK_amex_A000000025_index_10_exponent_03_PROD();
        addCAPK_amex_A000000025_index_0F_exponent_03_PROD();

//        addCAPK_amex_A000000025_index_C1_exponent_03_TEST();
//        addCAPK_amex_A000000025_index_C2_exponent_03_TEST();
//        addCAPK_amex_A000000025_index_C3_exponent_03_TEST();
//        addCAPK_amex_A000000025_index_C7_exponent_03_TEST();
//        addCAPK_amex_A000000025_index_C8_exponent_03_TEST();
//        addCAPK_amex_A000000025_index_C9_exponent_03_TEST();
//        addCAPK_amex_A000000025_index_CA_exponent_03_TEST();

        addCAPK_amex_A000000025_index_0F_exponent_03_PROD();
        addCAPK_amex_A000000025_index_10_exponent_03_PROD();

        addCapk_jcb_0F();
        addCapk_jcb_11();
        addCapk_jcb_13();

        addCAPK_emvL2_visa57();

        addCapk_carnet_01();
        addCapk_carnet_02();

        addAid_MasterCard_Maestro_Amex_Jcb__Cirrus();
        addAid_VisaElectron();
        addAid_Visa();
        addAid_DinersClubDiscover();
        addAid_Carnet();
    }

    void initCAPK() {
        emvApi.updateAID(Operation.CLEAR_EMV_AID, null);
        emvApi.updateAID(Operation.CLEAR_NFC_AID, null);
        this.initAID_CAPK();
        this.init_NfcAid_CAPK();
    }

    void init_NfcAid_CAPK() {
        if (debugModeEnabled) Log.d("Qpay", "my_testAid_NfcCard");
        boolean bret;

        Hashtable<String, String> aidData = new Hashtable<String, String>();
        //1
        aidData.put("CardType", "MasterCard");
        aidData.put("ApplicationIdentifier", "A0000000041010");//9F06
        aidData.put("ApplicationVersionNumber", "0002");//9F09

        aidData.put("DefaultUDOL", "9F6A04");//DF811A

        aidData.put("FloorLimit", "000000000000");//DF8123
        aidData.put("NoOnDeviceCVM", StringUtils.leftPadWithZeros(Integer.toString(CONTACTLESS_MAX_AMOUNT), 10) + "00");//contactless transaction limit DF8124
        aidData.put("OnDeviceCVM", StringUtils.leftPadWithZeros(Integer.toString(CONTACTLESS_MAX_AMOUNT), 10) + "00");// contactless transaction limit
        aidData.put("ReaderCVMRequiredLimit", StringUtils.leftPadWithZeros(Integer.toString(CONTACTLESS_MAX_AMOUNT), 10) + "00");//DF8126
        aidData.put("TerminalActionCodesOnLine", "F45084800C");//DF8122
        aidData.put("TerminalActionCodesDenial", "0000000000");//DF8121
        aidData.put("TerminalActionCodesDefault", "F45084800C");//DF8120
        aidData.put("TerminalRiskManagement", "6C7A000000000000");//9F1D
        aidData.put("TerminalCountryCode", "0484");//9f1A
        aidData.put("KernelConfiguration", "30");//add by max 20180716  20 normal // 30 for RRP support

        aidData.put("CardDataInputCapability", "60");//DF8117  // 60
        aidData.put("CVMCapabilityPerCVMRequired", "40");//DF8118
        aidData.put("CVMCapabilityNoCVMRequired", "08");//DF8119

        aidData.put("MagStripeCVMCapabilityCVMRequired", "10");// DF811E = "10";
        aidData.put("SecurityCapability", "08");//DF811F
        aidData.put("MagStripeCVMCapabilityPerNoCVMRequired", "00");// DF812C = "00";

        // DF811F = "08";

        bret = emvApi.updateAID(Operation.ADD, aidData);  //MasterCard
        if (debugModeEnabled) Log.d("Qpay", "updateAID 1:" + bret);
        //A0000000043060

        aidData.put("TerminalActionCodesOnLine", "F45004800C");//DF8122
        aidData.put("TerminalActionCodesDenial", "0000800000");//DF8121
        aidData.put("TerminalActionCodesDefault", "F45004800C");//DF8120

        aidData.put("TerminalRiskManagement", "4C7A800000000000");//9F1D
        aidData.put("ApplicationIdentifier", "A0000000043060");//9F06 //Maestro
        aidData.put("KernelConfiguration", "A0");//add by max 20180716
        aidData.put("TerminalTransactionQualifiers", "32004000"); // Tag:9F66 see page 15 in https://www.emvco.com/wp-content/uploads/2017/05/C-7_Kernel_7_v2.6_20160512101943350.pdf

        bret = emvApi.updateAID(Operation.ADD, aidData);
        if (debugModeEnabled) Log.d("Qpay", "updateAID 3:" + bret);
        //2
        //Object cardtype =
        //        payPassApi.NfcCardType.VisaCard;
        aidData.put("CardType", "VisaCard");
        aidData.put("ApplicationIdentifier", "A0000000031010");//9F06
        aidData.put("TerminalTransactionQualifiers", "32004000"); // Tag:9F66 see page 15 in https://www.emvco.com/wp-content/uploads/2017/05/C-7_Kernel_7_v2.6_20160512101943350.pdf
        aidData.put("TransactionLimit", StringUtils.leftPadWithZeros(Integer.toString(CONTACTLESS_MAX_AMOUNT), 10) + "01");//9F92810D
        aidData.put("FloorLimit", "000000000000");//9F92810F  //000000040000
        aidData.put("CvmRequiredLimit", StringUtils.leftPadWithZeros(Integer.toString(CONTACTLESS_MAX_AMOUNT), 10) + "01");//9F92810E   //000000030000

        aidData.put("LimitSwitch", "FE00");//9F92810A
        aidData.put("EmvTerminalFloorLimit", "00000000");//9F1B
        bret = emvApi.updateAID(Operation.ADD, aidData);
        if (debugModeEnabled) Log.d("Qpay", "VisaCard updateAID " + bret);

        ///////////////////////////
        aidData.put("CardType", "AmexCard");
        aidData.put("ApplicationIdentifier", "A00000002501");//9F06
        aidData.put("TerminalTransactionQualifiers", "58A04000");//9F6E  //58E00000  // D8E00000 support contact // Enhanced Contactless Reader Capabilities // Tag:9F6E see page 27 in https://www.emvco.com/wp-content/uploads/2017/05/C-4_Kernel_4_v2.6_20160512101635327.pdf tag is really called "Enhanced Contactless Reader Capabilities"
        aidData.put("Terminallimit", "C8");  //..Contactless Reader Capabilities – Tag '9F6D'
        aidData.put("Transactionlimit", "000000001500");//9F92810D
        aidData.put("FloorLimit", "000000000000");//9F92810F   //000000001200
        aidData.put("CvmRequiredLimit", "000000001000");//9F92810E
        aidData.put("LimitSwitch", "FE00");//9F92810A
        aidData.put("EmvTerminalFloorLimit", "00004E20");//9F1B   200000
        aidData.put("ApplicationVersion", "0001");//9f09
        aidData.put("TerminalActionCodesOnLine", "DE00FC9800");//DF8122
        aidData.put("TerminalActionCodesDenial", "0010000000");//DF8121
        aidData.put("TerminalActionCodesDefault", "DC50FC9800");//DF8120
        aidData.put("AmexRandom", "38");//9F928102

        bret = emvApi.updateAID(Operation.ADD, aidData);
        if (debugModeEnabled) Log.d("Qpay", "AmexCard updateAID " + bret);

        aidData.put("CardType", "JcbCard");
        aidData.put("ApplicationIdentifier", "A0000000651010");//9F06
        aidData.put("ConfigurationCombinationOptions", "7B00");//
        aidData.put("StaticTerminalInterchangeProfile", "708000");//

        aidData.put("Transactionlimit", StringUtils.leftPadWithZeros(Integer.toString(CONTACTLESS_MAX_AMOUNT), 10) + "01");//9F92810D
        aidData.put("FloorLimit", "000000000000");//9F92810F   //000000001200
        aidData.put("CvmRequiredLimit", StringUtils.leftPadWithZeros(Integer.toString(CONTACTLESS_MAX_AMOUNT), 10) + "01");//9F92810E

        aidData.put("EmvTerminalFloorLimit", "00004E20");//9F1B
        aidData.put("ApplicationVersion", "0200");//9f09
        aidData.put("TerminalActionCodesOnLine", "FC60ACF800");//DF8122
        aidData.put("TerminalActionCodesDenial", "0010000000");//DF8121
        aidData.put("TerminalActionCodesDefault", "FC6024A800");//DF8120

        aidData.put("ThresholdValue", "000000002000");
        aidData.put("TargetPercentage", "00");
        aidData.put("MaxTargetPercentage", "00");

        aidData.put("AcquirerIdentifier", "000000000010");
        aidData.put("MerchantCategoryCode", "7032");
        aidData.put("MerchantNameAndLocation", "5858204D45524348414E54205959204C4F434154494F4E");
        aidData.put("RemovalTimeout", "1000");

        bret = emvApi.updateAID(Operation.ADD, aidData);
        if (debugModeEnabled) Log.d("Qpay", "JcbCard updateAID " + bret);

        /////////////////////////

        aidData.put("CardType", "DiscoverCard");
        aidData.put("ApplicationIdentifier", "A0000001523010");//9F06
        aidData.put("TerminalTransactionQualifiers", "B280C000"); // Tag:9F66 see page 15 in https://www.emvco.com/wp-content/uploads/2017/05/C-7_Kernel_7_v2.6_20160512101943350.pdf
        aidData.put("ConfigurationCombinationOptions", "F000");//

        aidData.put("StaticTerminalInterchangeProfile", "708000");//

        aidData.put("Transactionlimit", StringUtils.leftPadWithZeros(Integer.toString(CONTACTLESS_MAX_AMOUNT), 10) + "01");//9F92810D
        aidData.put("FloorLimit", "000000000000");//9F92810F   //000000001200
        aidData.put("CvmRequiredLimit", StringUtils.leftPadWithZeros(Integer.toString(CONTACTLESS_MAX_AMOUNT), 10) + "01");//9F92810E

        aidData.put("EmvTerminalFloorLimit", "00004E20");//9F1B
        aidData.put("ApplicationVersion", "0200");//9f09
        aidData.put("TerminalActionCodesOnLine", "FC60ACF800");//DF8122
        aidData.put("TerminalActionCodesDenial", "0010000000");//DF8121
        aidData.put("TerminalActionCodesDefault", "FC6024A800");//DF8120

        aidData.put("ThresholdValue", "000000002000");
        aidData.put("TargetPercentage", "00");
        aidData.put("MaxTargetPercentage", "00");

        aidData.put("MerchantCategoryCode", "7032");
        aidData.put("MerchantNameAndLocation", "5858204D45524348414E54205959204C4F434154494F4E");
        aidData.put("RemovalTimeout", "1000");

        bret = emvApi.updateAID(Operation.ADD, aidData);
        if (debugModeEnabled) Log.d("Qpay", "DiscoverCard updateAID " + bret);


        /////////////////////////
        Hashtable<String, String> data = new Hashtable<String, String>();

        /*
         * Added after contacting support, fixes issue with HSBC or other card transaction getting terminated
         */
        data.put("Rid", "A000000003");
        data.put("Index", "05");
        data.put("ExpirationDate", "20311223");
        data.put("Modulus", "D0135CE8A4436C7F9D5CC66547E30EA402F98105B71722E24BC08DCC80AB7E71EC23B8CE6A1DC6AC2A8CF55543D74A8AE7B388F9B174B7F0D756C22CBB5974F9016A56B601CCA64C71F04B78E86C501B193A5556D5389ECE4DEA258AB97F52A3");
        data.put("Exponent", "03");
        bret = emvApi.updateCAPK(Operation.ADD, data);
        if (debugModeEnabled) Log.d("Qpay", "updateCAPK " + bret);


        data.put("Rid", "A000000003");
        data.put("Index", "08");
        data.put("ExpirationDate", "20311223");
        data.put("Modulus", "D9FD6ED75D51D0E30664BD157023EAA1FFA871E4DA65672B863D255E81E137A51DE4F72BCC9E44ACE12127F87E263D3AF9DD9CF35CA4A7B01E907000BA85D24954C2FCA3074825DDD4C0C8F186CB020F683E02F2DEAD3969133F06F7845166ACEB57CA0FC2603445469811D293BFEFBAFAB57631B3DD91E796BF850A25012F1AE38F05AA5C4D6D03B1DC2E568612785938BBC9B3CD3A910C1DA55A5A9218ACE0F7A21287752682F15832A678D6E1ED0B");
        data.put("Exponent", "03");
        bret = emvApi.updateCAPK(Operation.ADD, data);
        if (debugModeEnabled) Log.d("Qpay", "updateCAPK " + bret);

        /*
         * Added after contacting support, fixes issue with HSBC or other card transaction getting terminated
         */
        data.put("Rid", "A000000003");
        data.put("Index", "09");
        data.put("ExpirationDate", "20311223");
        data.put("Modulus", "9D912248DE0A4E39C1A7DDE3F6D2588992C1A4095AFBD1824D1BA74847F2BC4926D2EFD904B4B54954CD189A54C5D1179654F8F9B0D2AB5F0357EB642FEDA95D3912C6576945FAB897E7062CAA44A4AA06B8FE6E3DBA18AF6AE3738E30429EE9BE03427C9D64F695FA8CAB4BFE376853EA34AD1D76BFCAD15908C077FFE6DC5521ECEF5D278A96E26F57359FFAEDA19434B937F1AD999DC5C41EB11935B44C18100E857F431A4A5A6BB65114F174C2D7B59FDF237D6BB1DD0916E644D709DED56481477C75D95CDD68254615F7740EC07F330AC5D67BCD75BF23D28A140826C026DBDE971A37CD3EF9B8DF644AC385010501EFC6509D7A41");
        data.put("Exponent", "03");
        bret = emvApi.updateCAPK(Operation.ADD, data);
        if (debugModeEnabled) Log.d("Qpay", "updateCAPK " + bret);

        // jcb test 20190927
        data.put("Rid", "A000000065");
        data.put("Index", "11");
        data.put("ExpirationDate", "20311223");
        data.put("Modulus", "A2583AA40746E3A63C22478F576D1EFC5FB046135A6FC739E82B55035F71B09BEB566EDB9968DD649B94B6DEDC033899884E908C27BE1CD291E5436F762553297763DAA3B890D778C0F01E3344CECDFB3BA70D7E055B8C760D0179A403D6B55F2B3B083912B183ADB7927441BED3395A199EEFE0DEBD1F5FC3264033DA856F4A8B93916885BD42F9C1F456AAB8CFA83AC574833EB5E87BB9D4C006A4B5346BD9E17E139AB6552D9C58BC041195336485");
        data.put("Exponent", "03");
        bret = emvApi.updateCAPK(Operation.ADD, data);
        if (debugModeEnabled) Log.d("Qpay", "updateCAPK " + bret);

        data.put("Index", "92");
        data.put("Modulus", "996AF56F569187D09293C14810450ED8EE3357397B18A2458EFAA92DA3B6DF6514EC060195318FD43BE9B8F0CC669E3F844057CBDDF8BDA191BB64473BC8DC9A730DB8F6B4EDE3924186FFD9B8C7735789C23A36BA0B8AF65372EB57EA5D89E7D14E9C7B6B557460F10885DA16AC923F15AF3758F0F03EBD3C5C2C949CBA306DB44E6A2C076C5F67E281D7EF56785DC4D75945E491F01918800A9E2DC66F60080566CE0DAF8D17EAD46AD8E30A247C9F");
        bret = emvApi.updateCAPK(Operation.ADD, data);

        data.put("Index", "89");
        data.put("Modulus", "E5E195705CE61A0672B8367E7A51713927A04289EA308328FAD28071ECEAE889B3C4F29AC3BDE46772B00D42FD05F27228820F2693990F81B0F6928E240D957EC4484354CD5E5CA9092B444741A0394D3476651232474A9B87A961DA8DD96D90F036E9B3C52FB09766BDA4D6BC3BDADBC89122B74068F8FA04026C5FA8EF398BC3AB3992A87F6A785CC779BA99F170956623D67A18EB8324263D626BE85BFF77B8B981C0A3F7849C4F3D8E20542955D19128198547B47AE34DF67F28BE433F33");
        bret = emvApi.updateCAPK(Operation.ADD, data);


        //mastercard
        data.put("Rid", "A000000004");
        data.put("Index", "04");
        data.put("ExpirationDate", "20311223");
        data.put("Modulus", "A6DA428387A502D7DDFB7A74D3F412BE762627197B25435B7A81716A700157DDD06F7CC99D6CA28C2470527E2C03616B9C59217357C2674F583B3BA5C7DCF2838692D023E3562420B4615C439CA97C44DC9A249CFCE7B3BFB22F68228C3AF13329AA4A613CF8DD853502373D62E49AB256D2BC17120E54AEDCED6D96A4287ACC5C04677D4A5A320DB8BEE2F775E5FEC5");
        data.put("Exponent", "03");
        bret = emvApi.updateCAPK(Operation.ADD, data);

        data.put("Index", "05");
        data.put("Modulus", "B8048ABC30C90D976336543E3FD7091C8FE4800DF820ED55E7E94813ED00555B573FECA3D84AF6131A651D66CFF4284FB13B635EDD0EE40176D8BF04B7FD1C7BACF9AC7327DFAA8AA72D10DB3B8E70B2DDD811CB4196525EA386ACC33C0D9D4575916469C4E4F53E8E1C912CC618CB22DDE7C3568E90022E6BBA770202E4522A2DD623D180E215BD1D1507FE3DC90CA310D27B3EFCCD8F83DE3052CAD1E48938C68D095AAC91B5F37E28BB49EC7ED597");
        bret = emvApi.updateCAPK(Operation.ADD, data);

        data.put("Index", "06");
        data.put("Modulus", "CB26FC830B43785B2BCE37C81ED334622F9622F4C89AAE641046B2353433883F307FB7C974162DA72F7A4EC75D9D657336865B8D3023D3D645667625C9A07A6B7A137CF0C64198AE38FC238006FB2603F41F4F3BB9DA1347270F2F5D8C606E420958C5F7D50A71DE30142F70DE468889B5E3A08695B938A50FC980393A9CBCE44AD2D64F630BB33AD3F5F5FD495D31F37818C1D94071342E07F1BEC2194F6035BA5DED3936500EB82DFDA6E8AFB655B1EF3D0D7EBF86B66DD9F29F6B1D324FE8B26CE38AB2013DD13F611E7A594D675C4432350EA244CC34F3873CBA06592987A1D7E852ADC22EF5A2EE28132031E48F74037E3B34AB747F");
        bret = emvApi.updateCAPK(Operation.ADD, data);

        data.put("Index", "FA");
        data.put("Modulus", "A90FCD55AA2D5D9963E35ED0F440177699832F49C6BAB15CDAE5794BE93F934D4462D5D12762E48C38BA83D8445DEAA74195A301A102B2F114EADA0D180EE5E7A5C73E0C4E11F67A43DDAB5D55683B1474CC0627F44B8D3088A492FFAADAD4F42422D0E7013536C3C49AD3D0FAE96459B0F6B1B6056538A3D6D44640F94467B108867DEC40FAAECD740C00E2B7A8852D");
        bret = emvApi.updateCAPK(Operation.ADD, data);

        data.put("Index", "F1");
        data.put("Modulus", "A0DCF4BDE19C3546B4B6F0414D174DDE294AABBB828C5A834D73AAE27C99B0B053A90278007239B6459FF0BBCD7B4B9C6C50AC02CE91368DA1BD21AAEADBC65347337D89B68F5C99A09D05BE02DD1F8C5BA20E2F13FB2A27C41D3F85CAD5CF6668E75851EC66EDBF98851FD4E42C44C1D59F5984703B27D5B9F21B8FA0D93279FBBF69E090642909C9EA27F898959541AA6757F5F624104F6E1D3A9532F2A6E51515AEAD1B43B3D7835088A2FAFA7BE7");
        bret = emvApi.updateCAPK(Operation.ADD, data);

        data.put("Index", "FE");
        data.put("Modulus", "A653EAC1C0F786C8724F737F172997D63D1C3251C44402049B865BAE877D0F398CBFBE8A6035E24AFA086BEFDE9351E54B95708EE672F0968BCD50DCE40F783322B2ABA04EF137EF18ABF03C7DBC5813AEAEF3AA7797BA15DF7D5BA1CBAF7FD520B5A482D8D3FEE105077871113E23A49AF3926554A70FE10ED728CF793B62A1");
        bret = emvApi.updateCAPK(Operation.ADD, data);

        data.put("Index", "F3");
        data.put("Modulus", "98F0C770F23864C2E766DF02D1E833DFF4FFE92D696E1642F0A88C5694C6479D16DB1537BFE29E4FDC6E6E8AFD1B0EB7EA0124723C333179BF19E93F10658B2F776E829E87DAEDA9C94A8B3382199A350C077977C97AFF08FD11310AC950A72C3CA5002EF513FCCC286E646E3C5387535D509514B3B326E1234F9CB48C36DDD44B416D23654034A66F403BA511C5EFA3");
        bret = emvApi.updateCAPK(Operation.ADD, data);

        data.put("Index", "EF");
        data.put("Modulus", "A191CB87473F29349B5D60A88B3EAEE0973AA6F1A082F358D849FDDFF9C091F899EDA9792CAF09EF28F5D22404B88A2293EEBBC1949C43BEA4D60CFD879A1539544E09E0F09F60F065B2BF2A13ECC705F3D468B9D33AE77AD9D3F19CA40F23DCF5EB7C04DC8F69EBA565B1EBCB4686CD274785530FF6F6E9EE43AA43FDB02CE00DAEC15C7B8FD6A9B394BABA419D3F6DC85E16569BE8E76989688EFEA2DF22FF7D35C043338DEAA982A02B866DE5328519EBBCD6F03CDD686673847F84DB651AB86C28CF1462562C577B853564A290C8556D818531268D25CC98A4CC6A0BDFFFDA2DCCA3A94C998559E307FDDF915006D9A987B07DDAEB3B");
        bret = emvApi.updateCAPK(Operation.ADD, data);

        data.put("CardType", "NfcCard");//amex
        data.put("Rid", "A000000025");
        data.put("Index", "10");
        data.put("ExpirationDate", "20311223");
        data.put("Modulus", "CF98DFEDB3D3727965EE7797723355E0751C81D2D3DF4D18EBAB9FB9D49F38C8C4A826B99DC9DEA3F01043D4BF22AC3550E2962A59639B1332156422F788B9C16D40135EFD1BA94147750575E636B6EBC618734C91C1D1BF3EDC2A46A43901668E0FFC136774080E888044F6A1E65DC9AAA8928DACBEB0DB55EA3514686C6A732CEF55EE27CF877F110652694A0E3484C855D882AE191674E25C296205BBB599455176FDD7BBC549F27BA5FE35336F7E29E68D783973199436633C67EE5A680F05160ED12D1665EC83D1997F10FD05BBDBF9433E8F797AEE3E9F02A34228ACE927ABE62B8B9281AD08D3DF5C7379685045D7BA5FCDE58637");
        data.put("Exponent", "03");
        bret = emvApi.updateCAPK(Operation.ADD, data);

        data.put("Index", "0F");
        data.put("Modulus", "C8D5AC27A5E1FB89978C7C6479AF993AB3800EB243996FBB2AE26B67B23AC482C4B746005A51AFA7D2D83E894F591A2357B30F85B85627FF15DA12290F70F05766552BA11AD34B7109FA49DE29DCB0109670875A17EA95549E92347B948AA1F045756DE56B707E3863E59A6CBE99C1272EF65FB66CBB4CFF070F36029DD76218B21242645B51CA752AF37E70BE1A84FF31079DC0048E928883EC4FADD497A719385C2BBBEBC5A66AA5E5655D18034EC5");
        bret = emvApi.updateCAPK(Operation.ADD, data);

// Amex test card needed for certification, do not use in production
//        data.put("CardType", "NfcCard");//amex
//        data.put("Rid", "A000000025");
//        data.put("Index", "C9");
//        data.put("ExpirationDate", "20311223");
//        data.put("Modulus", "B362DB5733C15B8797B8ECEE55CB1A371F760E0BEDD3715BB270424FD4EA26062C38C3F4AAA3732A83D36EA8E9602F6683EECC6BAFF63DD2D49014BDE4D6D603CD744206B05B4BAD0C64C63AB3976B5C8CAAF8539549F5921C0B700D5B0F83C4E7E946068BAAAB5463544DB18C63801118F2182EFCC8A1E85E53C2A7AE839A5C6A3CABE73762B70D170AB64AFC6CA482944902611FB0061E09A67ACB77E493D998A0CCF93D81A4F6C0DC6B7DF22E62DB");
//        data.put("Exponent", "03");
//        bret = emvApi.updateCAPK(Operation.ADD, data);
//
//        data.put("Index", "C8");
//        data.put("Modulus", "BF0CFCED708FB6B048E3014336EA24AA007D7967B8AA4E613D26D015C4FE7805D9DB131CED0D2A8ED504C3B5CCD48C33199E5A5BF644DA043B54DBF60276F05B1750FAB39098C7511D04BABC649482DDCF7CC42C8C435BAB8DD0EB1A620C31111D1AAAF9AF6571EEBD4CF5A08496D57E7ABDBB5180E0A42DA869AB95FB620EFF2641C3702AF3BE0B0C138EAEF202E21D");
//        bret = emvApi.updateCAPK(Operation.ADD, data);
//
//        data.put("Index", "CA");
//        data.put("Modulus", "C23ECBD7119F479C2EE546C123A585D697A7D10B55C2D28BEF0D299C01DC65420A03FE5227ECDECB8025FBC86EEBC1935298C1753AB849936749719591758C315FA150400789BB14FADD6EAE2AD617DA38163199D1BAD5D3F8F6A7A20AEF420ADFE2404D30B219359C6A4952565CCCA6F11EC5BE564B49B0EA5BF5B3DC8C5C6401208D0029C3957A8C5922CBDE39D3A564C6DEBB6BD2AEF91FC27BB3D3892BEB9646DCE2E1EF8581EFFA712158AAEC541C0BBB4B3E279D7DA54E45A0ACC3570E712C9F7CDF985CFAFD382AE13A3B214A9E8E1E71AB1EA707895112ABC3A97D0FCB0AE2EE5C85492B6CFD54885CDD6337E895CC70FB3255E3");
//        bret = emvApi.updateCAPK(Operation.ADD, data);

    }

}
