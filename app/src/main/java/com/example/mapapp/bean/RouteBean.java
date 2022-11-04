package com.example.mapapp.bean;

import java.util.List;

public class RouteBean {


    /**
     * geocoded_waypoints : [{"geocoder_status":"OK","place_id":"ChIJIYLWarBW8DUR3GzB7K-Nj7A","types":["establishment","point_of_interest","university"]},{"geocoder_status":"OK","place_id":"ChIJn3ULb0xT8DURAl47G3WUQcI","types":["cafe","establishment","food","point_of_interest","store"]}]
     * routes : [{"bounds":{"northeast":{"lat":39.9970333,"lng":116.4154595},"southwest":{"lat":39.93809,"lng":116.29752}},"copyrights":"Map data ©2022","legs":[{"distance":{"text":"17.7 公里","value":17720},"duration":{"text":"23分钟","value":1404},"end_address":"中国北京市东城区蒋宅口雍和宫桥西北角（近快客） 邮政编码: 100011","end_location":{"lat":39.9492079,"lng":116.4154595},"start_address":"中国北京市海淀区未名北路X8W6+MMR 邮政编码: 100084","start_location":{"lat":39.9970333,"lng":116.310823},"steps":[{"distance":{"text":"0.1 公里","value":115},"duration":{"text":"1分钟","value":28},"end_location":{"lat":39.99601,"lng":116.31084},"html_instructions":"向<b>南<\/b>方向，前往<b>镜春路<\/b>","polyline":{"points":"m|bsFs}{dU\\Cv@IPC\\@RDTFL?LA"},"start_location":{"lat":39.9970333,"lng":116.310823},"travel_mode":"DRIVING"},{"distance":{"text":"0.5 公里","value":510},"duration":{"text":"2分钟","value":133},"end_location":{"lat":39.99298,"lng":116.31392},"html_instructions":"继续前行，上<b>未名北路<\/b>","polyline":{"points":"avbsFw}{dUPCFCHCVa@LWNMRIZKn@QREB?l@ApBEN?^CBABAz@k@BCv@a@JGd@i@FS@e@?iA?_@AO@}C"},"start_location":{"lat":39.99601,"lng":116.31084},"travel_mode":"DRIVING"},{"distance":{"text":"0.1 公里","value":103},"duration":{"text":"1分钟","value":23},"end_location":{"lat":39.99205,"lng":116.31393},"html_instructions":"向<b>右<\/b>转，前往<b>大城坊<\/b>","maneuver":"turn-right","polyline":{"points":"ccbsF_q|dUP?fDA"},"start_location":{"lat":39.99298,"lng":116.31392},"travel_mode":"DRIVING"},{"distance":{"text":"0.2 公里","value":151},"duration":{"text":"1分钟","value":51},"end_location":{"lat":39.9921099,"lng":116.31569},"html_instructions":"在第 1 个交叉路口向<b>左<\/b>转，进入<b>大城坊<\/b>","maneuver":"turn-left","polyline":{"points":"i}asFaq|dU?W@yC?sAE}@G["},"start_location":{"lat":39.99205,"lng":116.31393},"travel_mode":"DRIVING"},{"distance":{"text":"0.6 公里","value":609},"duration":{"text":"2分钟","value":93},"end_location":{"lat":39.98665,"lng":116.31616},"html_instructions":"向<b>右<\/b>急转，进入<b>中关村北大街<\/b>","maneuver":"turn-sharp-right","polyline":{"points":"u}asFa||dU`@ER?xFUR?d@Cj@ChDOjBI`AC|@EhACt@EVAVAv@CPA\\A"},"start_location":{"lat":39.9921099,"lng":116.31569},"travel_mode":"DRIVING"},{"distance":{"text":"0.1 公里","value":116},"duration":{"text":"1分钟","value":30},"end_location":{"lat":39.98569,"lng":116.31624},"html_instructions":"向<b>右<\/b>转，进入<b>海淀路<\/b> （<b>N 4th Ring<\/b>/<wbr/><b>北四环<\/b>/<wbr/><b>Bei Si Huan<\/b>/<wbr/><b>Haidian Brg<\/b>/<wbr/><b>海淀桥<\/b>/<wbr/><b>Hai Dian Qiao<\/b>的路标）","maneuver":"turn-right","polyline":{"points":"q{`sF__}dUh@b@NEx@Ed@ENMTS"},"start_location":{"lat":39.98665,"lng":116.31616},"travel_mode":"DRIVING"},{"distance":{"text":"0.4 公里","value":379},"duration":{"text":"1分钟","value":67},"end_location":{"lat":39.98556,"lng":116.31179},"html_instructions":"向<b>右<\/b>急转，进入<b>北四环西路辅路<\/b>","maneuver":"turn-sharp-right","polyline":{"points":"qu`sFo_}dU@dA@l@@|AJhK@zA@t@BjC"},"start_location":{"lat":39.98569,"lng":116.31624},"travel_mode":"DRIVING"},{"distance":{"text":"71 米","value":71},"duration":{"text":"1分钟","value":9},"end_location":{"lat":39.98542,"lng":116.31098},"html_instructions":"走<b>左侧<\/b>匝道，前往<b>N 4th Ring W Rd<\/b>/<wbr/><b>北四环西路<\/b>/<wbr/><b>Bei Si Huan Xi Lu<\/b>","maneuver":"ramp-left","polyline":{"points":"wt`sFuc|dUZ`D"},"start_location":{"lat":39.98556,"lng":116.31179},"travel_mode":"DRIVING"},{"distance":{"text":"0.1 公里","value":130},"duration":{"text":"1分钟","value":7},"end_location":{"lat":39.98536,"lng":116.30946},"html_instructions":"走<b>北四环<\/b>/<wbr/><b>北四环西路<\/b>/<wbr/><b>四环<\/b>","maneuver":"merge","polyline":{"points":"{s`sFs~{dUFnE@r@@j@"},"start_location":{"lat":39.98542,"lng":116.31098},"travel_mode":"DRIVING"},{"distance":{"text":"0.5 公里","value":484},"duration":{"text":"1分钟","value":26},"end_location":{"lat":39.9851699,"lng":116.30379},"html_instructions":"靠<b>左<\/b>继续沿<b>北四环<\/b>/<wbr/><b>北四环西路<\/b>/<wbr/><b>四环<\/b>/<wbr/><b>海淀桥<\/b>行驶","maneuver":"keep-left","polyline":{"points":"os`sFcu{dUF`F?\\@`@?FL|K?L@^?\\@|@@r@FfF"},"start_location":{"lat":39.98536,"lng":116.30946},"travel_mode":"DRIVING"},{"distance":{"text":"0.2 公里","value":215},"duration":{"text":"1分钟","value":11},"end_location":{"lat":39.98511999999999,"lng":116.30127},"html_instructions":"靠<b>左<\/b>继续沿<b>万泉河桥<\/b>/<wbr/><b>北四环<\/b>/<wbr/><b>北四环西路<\/b>/<wbr/><b>四环<\/b>行驶","maneuver":"keep-left","polyline":{"points":"ir`sFuqzdU@`BDpD@pB?pB"},"start_location":{"lat":39.9851699,"lng":116.30379},"travel_mode":"DRIVING"},{"distance":{"text":"0.8 公里","value":756},"duration":{"text":"1分钟","value":54},"end_location":{"lat":39.98189,"lng":116.30041},"html_instructions":"下出口，前往<b>W 3rd Ring<\/b>/<wbr/><b>西三环<\/b>/<wbr/><b>Xi San Huan<\/b>/<wbr/><b>Suzhou Brg<\/b>/<wbr/><b>苏州桥<\/b>/<wbr/><b>Su Zhou Qiao<\/b>/<wbr/><b>Wanquanhe Rd<\/b>/<wbr/><b>万泉河路<\/b>/<wbr/><b>Wan Quan He Lu<\/b>","maneuver":"ramp-right","polyline":{"points":"_r`sF}azdUC|@?\\?FAl@An@?V?T?V@`@?V?jF?P@X?@@JBTBJ@FDPHP@@BDBDFHHFFDNJPDD@b@ARCDCFEHGDEBCHMJOFKNUHOLY\\s@Re@Te@Te@BGx@eB@ADIJMFGHIPQJKTQz@_@b@Qj@U"},"start_location":{"lat":39.98511999999999,"lng":116.30127},"travel_mode":"DRIVING"},{"distance":{"text":"2.6 公里","value":2625},"duration":{"text":"3分钟","value":164},"end_location":{"lat":39.9602,"lng":116.30833},"html_instructions":"走<b>万泉河路<\/b>","maneuver":"merge","polyline":{"points":"y}_sFq|ydUPAB?nDMfAEfAGb@AJAZAp@ETAb@Cf@CbAEb@C`@CF?ZCxBK\\ANAfAEL?`@AP?vAGRANAb@CfAGVCn@EF?h@EJAHATCJAJADADAB?bAWHEFCRIb@WVMf@[\\Yh@e@j@q@X_@f@o@HQXi@l@gA@CT_@nA_Cl@gAbAmBBE`@y@DI`@q@LSXk@LUDEJQb@q@DGHIHILKVOVMDARCVE|@G|@IvCQF?rBKfAIjAKd@EfAIlAKrBWx@IRCv@KlC[h@GbBQ\\EDAb@EVE^EXC\\CFAFA|B?pA?XAJA\\CVGfA]"},"start_location":{"lat":39.98189,"lng":116.30041},"travel_mode":"DRIVING"},{"distance":{"text":"1.6 公里","value":1578},"duration":{"text":"2分钟","value":96},"end_location":{"lat":39.94607,"lng":116.30986},"html_instructions":"继续前行，上<b>三环<\/b>/<wbr/><b>西三环<\/b>/<wbr/><b>西三环北路<\/b>","polyline":{"points":"gv{rFan{dUbAMZElBW~Cc@XE~AUd@GfCYhBKd@CXCNA`DMxBItBIb@ApCIJ?J?JAxAG|EQjAEpAExDKpDKVAh@AdDIH?nAEv@C^A|ACRA"},"start_location":{"lat":39.9602,"lng":116.30833},"travel_mode":"DRIVING"},{"distance":{"text":"1.0 公里","value":983},"duration":{"text":"1分钟","value":79},"end_location":{"lat":39.93981,"lng":116.31633},"html_instructions":"下<b>左侧<\/b>出口，前往<b>Xiwai Ave<\/b>/<wbr/><b>西外大街<\/b>/<wbr/><b>Xi Wai Da Jie<\/b>/<wbr/><b>W 2nd Ring<\/b>/<wbr/><b>西二环<\/b>/<wbr/><b>Xi Er Huan<\/b>/<wbr/><b>Xizhimen Brg<\/b>/<wbr/><b>西直门桥<\/b>/<wbr/><b>Xi Zhi Men Qiao<\/b>","maneuver":"ramp-left","polyline":{"points":"}}xrFsw{dUz@MPCf@CbAG|BGn@CVAbACd@C@?ZEh@ObA[r@_@JIJI`@[PQRSJMFGFIZe@DIp@kAb@eA@Cz@wCd@aBzAsF^qABK\\oAXoAh@_B"},"start_location":{"lat":39.94607,"lng":116.30986},"travel_mode":"DRIVING"},{"distance":{"text":"0.8 公里","value":789},"duration":{"text":"1分钟","value":47},"end_location":{"lat":39.93877,"lng":116.32545},"html_instructions":"走<b>紫竹院路<\/b>","maneuver":"merge","polyline":{"points":"yvwrFa`}dUVoAN_AF_@DYBQFg@V{BRgCDo@D{@F_B@YF}A@m@@S@Y@o@Bm@BaADiAF}BB{@HiCBkA@SDoAB{@Bm@Bo@"},"start_location":{"lat":39.93981,"lng":116.31633},"travel_mode":"DRIVING"},{"distance":{"text":"2.3 公里","value":2273},"duration":{"text":"2分钟","value":133},"end_location":{"lat":39.94007999999999,"lng":116.35172},"html_instructions":"继续前行，上<b>西外大街<\/b>","polyline":{"points":"ipwrFay~dU@U?E?Q@SB_A?IBm@HyB@Q?Q@I@SJyDDwANgEFmB@Q@_@Dw@DgAFaBDsABk@?SJmC@_@@]FgB@W@s@@wA@aBAaB?iACcBAeACcAG{DAw@KuDCwAAkACkAAcAAg@GoD?[A]Ag@A_@AUAgAIwD?GG_ACe@KaBEa@Go@AQO_Ag@cCMk@u@yC_@eBIa@QeAEWAOQoAAIKoAAMIaAAUEg@Ek@CUIeAASKyAC["},"start_location":{"lat":39.93877,"lng":116.32545},"travel_mode":"DRIVING"},{"distance":{"text":"0.8 公里","value":848},"duration":{"text":"1分钟","value":65},"end_location":{"lat":39.94427,"lng":116.35814},"html_instructions":"下出口，前往<b>N 2nd Ring<\/b>/<wbr/><b>北二环<\/b>/<wbr/><b>Bei Er Huan<\/b>/<wbr/><b>Jishuitan Brg<\/b>/<wbr/><b>积水潭桥<\/b>/<wbr/><b>Ji Shui Tan Qiao<\/b>","maneuver":"ramp-right","polyline":{"points":"oxwrFg}ceU@M@MCk@?Q?Q?C?E?U?QAoA?MCw@C{@AQCs@Ag@E}A?EEy@?EKc@GMIq@IIEGEGEEIGAAKIIAc@KWC_@CU?oB@_@CUAMCk@IWGAA_@Mm@YUMIEUOEEUUa@g@MSS]GIIQKQEIIUUo@Oc@AE[aAIK"},"start_location":{"lat":39.94007999999999,"lng":116.35172},"travel_mode":"DRIVING"},{"distance":{"text":"3.1 公里","value":3135},"duration":{"text":"3分钟","value":185},"end_location":{"lat":39.94891,"lng":116.39376},"html_instructions":"走<b>二环<\/b>/<wbr/><b>北二环<\/b>","maneuver":"merge","polyline":{"points":"urxrFkeeeUw@sDc@uBMo@CMUoAc@gC]uB]mB]iBG_@y@oEa@qB_AgE[qAmA_Eu@_COg@e@uA]eAMc@YcA_@uAa@iBQy@EOAEAGKo@QmAScCCa@?EAS?E?EAIASCi@I_DAc@A}@EwBIqCAw@CmB?kB?IAm@?Q?e@?c@?g@AaI?K?G?IA}A?oA?KAoACeD@{@?mC@aBAqDCyHAqC?mCAmC?sAAqDAu@?uA?}AAkC?yB?a@?aAC{J?c@?I"},"start_location":{"lat":39.94427,"lng":116.35814},"travel_mode":"DRIVING"},{"distance":{"text":"1.6 公里","value":1606},"duration":{"text":"1分钟","value":89},"end_location":{"lat":39.94909,"lng":116.4126},"html_instructions":"靠<b>右<\/b>继续沿<b>二环<\/b>/<wbr/><b>北二环<\/b>行驶","maneuver":"keep-right","polyline":{"points":"uoyrF_dleU?O?I?O?_@As@?M?Q?MAiD?E?KAaJ?E?UAyB?}A?q@CiJCgOAsF?w@?y@?s@AkA?yAA{G?_AA{B?o@AqCCuF?q@CwC?IAqD"},"start_location":{"lat":39.94891,"lng":116.39376},"travel_mode":"DRIVING"},{"distance":{"text":"0.2 公里","value":244},"duration":{"text":"1分钟","value":14},"end_location":{"lat":39.9492079,"lng":116.4154595},"html_instructions":"靠<b>左<\/b>继续沿<b>二环<\/b>/<wbr/><b>北二环<\/b>/<wbr/><b>雍和宫桥<\/b>行驶<div style=\"font-size:0.9em\">目的地在右侧<\/div>","maneuver":"keep-left","polyline":{"points":"ypyrFwyoeUKaIEaC?KEkB"},"start_location":{"lat":39.94909,"lng":116.4126},"travel_mode":"DRIVING"}],"traffic_speed_entry":[],"via_waypoint":[]}],"overview_polyline":{"points":"m|bsFs}{dUtAMPC\\@h@LZAXGHCVa@LWNMn@UbAWp@A`CEb@E~@m@z@e@p@q@FS@e@?iB?mDxDA@qD?sAE}@G[`@ElGUx@CbKa@tEQ~BIh@b@NE~AKd@a@BrBPxRBjCZ`DHbGJlIZjYFrG@bFEpCAtB@vHF|@DRNb@PVPLNJPDh@?RC\\W`@m@Xe@j@mAbAyBz@gBPWn@o@TQz@_@nAg@lGUrCMdH]bEShCG~COvCQxBUfAWPIv@a@~@i@fA_Aj@q@`AoAb@{@tCkFvCuFnA{BbA_Bf@g@n@]XEtAMtE[nGa@lBO`Ec@rGu@fHw@d@EdCAjBAh@E~Ae@~ASfKwAlDa@nCOdI]vHUnI[zVq@dGOnAOx@GhGUhBG\\Eh@ObA[r@_@VSr@m@n@s@`@o@p@kAb@eA|@{C`CuIb@}Av@_Dh@_BVoAV_Bh@oEXwDL{CLyDf@gQXeJT{Hp@wSXuHPmFLqEByDAkDQiLMmFEcDOgJEaCM}G]iFIaAw@cEcAeEi@gCW}AS_BYiDm@oIB[C}@?q@EgDKiDKcDSq@Iq@IIKOOMMKm@Mw@GeC@u@Ey@MYImAg@{@i@w@}@a@q@c@w@q@oB[aAIK{AiHkAuGaBmJ{AaI{AyGyD}Lk@iBy@yC{@yDMw@QmAScCCg@AYGmASyJKiECyEAoBCyQA{AAaF@oFEkNCaOC{KEcXCeICySKql@CgOIqQA{DQcMEwB"},"summary":"二环/北二环","warnings":[],"waypoint_order":[]}]
     * status : OK
     */

    private String status;
    /**
     * geocoder_status : OK
     * place_id : ChIJIYLWarBW8DUR3GzB7K-Nj7A
     * types : ["establishment","point_of_interest","university"]
     */

    private List<GeocodedWaypointsBean> geocoded_waypoints;
    /**
     * bounds : {"northeast":{"lat":39.9970333,"lng":116.4154595},"southwest":{"lat":39.93809,"lng":116.29752}}
     * copyrights : Map data ©2022
     * legs : [{"distance":{"text":"17.7 公里","value":17720},"duration":{"text":"23分钟","value":1404},"end_address":"中国北京市东城区蒋宅口雍和宫桥西北角（近快客） 邮政编码: 100011","end_location":{"lat":39.9492079,"lng":116.4154595},"start_address":"中国北京市海淀区未名北路X8W6+MMR 邮政编码: 100084","start_location":{"lat":39.9970333,"lng":116.310823},"steps":[{"distance":{"text":"0.1 公里","value":115},"duration":{"text":"1分钟","value":28},"end_location":{"lat":39.99601,"lng":116.31084},"html_instructions":"向<b>南<\/b>方向，前往<b>镜春路<\/b>","polyline":{"points":"m|bsFs}{dU\\Cv@IPC\\@RDTFL?LA"},"start_location":{"lat":39.9970333,"lng":116.310823},"travel_mode":"DRIVING"},{"distance":{"text":"0.5 公里","value":510},"duration":{"text":"2分钟","value":133},"end_location":{"lat":39.99298,"lng":116.31392},"html_instructions":"继续前行，上<b>未名北路<\/b>","polyline":{"points":"avbsFw}{dUPCFCHCVa@LWNMRIZKn@QREB?l@ApBEN?^CBABAz@k@BCv@a@JGd@i@FS@e@?iA?_@AO@}C"},"start_location":{"lat":39.99601,"lng":116.31084},"travel_mode":"DRIVING"},{"distance":{"text":"0.1 公里","value":103},"duration":{"text":"1分钟","value":23},"end_location":{"lat":39.99205,"lng":116.31393},"html_instructions":"向<b>右<\/b>转，前往<b>大城坊<\/b>","maneuver":"turn-right","polyline":{"points":"ccbsF_q|dUP?fDA"},"start_location":{"lat":39.99298,"lng":116.31392},"travel_mode":"DRIVING"},{"distance":{"text":"0.2 公里","value":151},"duration":{"text":"1分钟","value":51},"end_location":{"lat":39.9921099,"lng":116.31569},"html_instructions":"在第 1 个交叉路口向<b>左<\/b>转，进入<b>大城坊<\/b>","maneuver":"turn-left","polyline":{"points":"i}asFaq|dU?W@yC?sAE}@G["},"start_location":{"lat":39.99205,"lng":116.31393},"travel_mode":"DRIVING"},{"distance":{"text":"0.6 公里","value":609},"duration":{"text":"2分钟","value":93},"end_location":{"lat":39.98665,"lng":116.31616},"html_instructions":"向<b>右<\/b>急转，进入<b>中关村北大街<\/b>","maneuver":"turn-sharp-right","polyline":{"points":"u}asFa||dU`@ER?xFUR?d@Cj@ChDOjBI`AC|@EhACt@EVAVAv@CPA\\A"},"start_location":{"lat":39.9921099,"lng":116.31569},"travel_mode":"DRIVING"},{"distance":{"text":"0.1 公里","value":116},"duration":{"text":"1分钟","value":30},"end_location":{"lat":39.98569,"lng":116.31624},"html_instructions":"向<b>右<\/b>转，进入<b>海淀路<\/b> （<b>N 4th Ring<\/b>/<wbr/><b>北四环<\/b>/<wbr/><b>Bei Si Huan<\/b>/<wbr/><b>Haidian Brg<\/b>/<wbr/><b>海淀桥<\/b>/<wbr/><b>Hai Dian Qiao<\/b>的路标）","maneuver":"turn-right","polyline":{"points":"q{`sF__}dUh@b@NEx@Ed@ENMTS"},"start_location":{"lat":39.98665,"lng":116.31616},"travel_mode":"DRIVING"},{"distance":{"text":"0.4 公里","value":379},"duration":{"text":"1分钟","value":67},"end_location":{"lat":39.98556,"lng":116.31179},"html_instructions":"向<b>右<\/b>急转，进入<b>北四环西路辅路<\/b>","maneuver":"turn-sharp-right","polyline":{"points":"qu`sFo_}dU@dA@l@@|AJhK@zA@t@BjC"},"start_location":{"lat":39.98569,"lng":116.31624},"travel_mode":"DRIVING"},{"distance":{"text":"71 米","value":71},"duration":{"text":"1分钟","value":9},"end_location":{"lat":39.98542,"lng":116.31098},"html_instructions":"走<b>左侧<\/b>匝道，前往<b>N 4th Ring W Rd<\/b>/<wbr/><b>北四环西路<\/b>/<wbr/><b>Bei Si Huan Xi Lu<\/b>","maneuver":"ramp-left","polyline":{"points":"wt`sFuc|dUZ`D"},"start_location":{"lat":39.98556,"lng":116.31179},"travel_mode":"DRIVING"},{"distance":{"text":"0.1 公里","value":130},"duration":{"text":"1分钟","value":7},"end_location":{"lat":39.98536,"lng":116.30946},"html_instructions":"走<b>北四环<\/b>/<wbr/><b>北四环西路<\/b>/<wbr/><b>四环<\/b>","maneuver":"merge","polyline":{"points":"{s`sFs~{dUFnE@r@@j@"},"start_location":{"lat":39.98542,"lng":116.31098},"travel_mode":"DRIVING"},{"distance":{"text":"0.5 公里","value":484},"duration":{"text":"1分钟","value":26},"end_location":{"lat":39.9851699,"lng":116.30379},"html_instructions":"靠<b>左<\/b>继续沿<b>北四环<\/b>/<wbr/><b>北四环西路<\/b>/<wbr/><b>四环<\/b>/<wbr/><b>海淀桥<\/b>行驶","maneuver":"keep-left","polyline":{"points":"os`sFcu{dUF`F?\\@`@?FL|K?L@^?\\@|@@r@FfF"},"start_location":{"lat":39.98536,"lng":116.30946},"travel_mode":"DRIVING"},{"distance":{"text":"0.2 公里","value":215},"duration":{"text":"1分钟","value":11},"end_location":{"lat":39.98511999999999,"lng":116.30127},"html_instructions":"靠<b>左<\/b>继续沿<b>万泉河桥<\/b>/<wbr/><b>北四环<\/b>/<wbr/><b>北四环西路<\/b>/<wbr/><b>四环<\/b>行驶","maneuver":"keep-left","polyline":{"points":"ir`sFuqzdU@`BDpD@pB?pB"},"start_location":{"lat":39.9851699,"lng":116.30379},"travel_mode":"DRIVING"},{"distance":{"text":"0.8 公里","value":756},"duration":{"text":"1分钟","value":54},"end_location":{"lat":39.98189,"lng":116.30041},"html_instructions":"下出口，前往<b>W 3rd Ring<\/b>/<wbr/><b>西三环<\/b>/<wbr/><b>Xi San Huan<\/b>/<wbr/><b>Suzhou Brg<\/b>/<wbr/><b>苏州桥<\/b>/<wbr/><b>Su Zhou Qiao<\/b>/<wbr/><b>Wanquanhe Rd<\/b>/<wbr/><b>万泉河路<\/b>/<wbr/><b>Wan Quan He Lu<\/b>","maneuver":"ramp-right","polyline":{"points":"_r`sF}azdUC|@?\\?FAl@An@?V?T?V@`@?V?jF?P@X?@@JBTBJ@FDPHP@@BDBDFHHFFDNJPDD@b@ARCDCFEHGDEBCHMJOFKNUHOLY\\s@Re@Te@Te@BGx@eB@ADIJMFGHIPQJKTQz@_@b@Qj@U"},"start_location":{"lat":39.98511999999999,"lng":116.30127},"travel_mode":"DRIVING"},{"distance":{"text":"2.6 公里","value":2625},"duration":{"text":"3分钟","value":164},"end_location":{"lat":39.9602,"lng":116.30833},"html_instructions":"走<b>万泉河路<\/b>","maneuver":"merge","polyline":{"points":"y}_sFq|ydUPAB?nDMfAEfAGb@AJAZAp@ETAb@Cf@CbAEb@C`@CF?ZCxBK\\ANAfAEL?`@AP?vAGRANAb@CfAGVCn@EF?h@EJAHATCJAJADADAB?bAWHEFCRIb@WVMf@[\\Yh@e@j@q@X_@f@o@HQXi@l@gA@CT_@nA_Cl@gAbAmBBE`@y@DI`@q@LSXk@LUDEJQb@q@DGHIHILKVOVMDARCVE|@G|@IvCQF?rBKfAIjAKd@EfAIlAKrBWx@IRCv@KlC[h@GbBQ\\EDAb@EVE^EXC\\CFAFA|B?pA?XAJA\\CVGfA]"},"start_location":{"lat":39.98189,"lng":116.30041},"travel_mode":"DRIVING"},{"distance":{"text":"1.6 公里","value":1578},"duration":{"text":"2分钟","value":96},"end_location":{"lat":39.94607,"lng":116.30986},"html_instructions":"继续前行，上<b>三环<\/b>/<wbr/><b>西三环<\/b>/<wbr/><b>西三环北路<\/b>","polyline":{"points":"gv{rFan{dUbAMZElBW~Cc@XE~AUd@GfCYhBKd@CXCNA`DMxBItBIb@ApCIJ?J?JAxAG|EQjAEpAExDKpDKVAh@AdDIH?nAEv@C^A|ACRA"},"start_location":{"lat":39.9602,"lng":116.30833},"travel_mode":"DRIVING"},{"distance":{"text":"1.0 公里","value":983},"duration":{"text":"1分钟","value":79},"end_location":{"lat":39.93981,"lng":116.31633},"html_instructions":"下<b>左侧<\/b>出口，前往<b>Xiwai Ave<\/b>/<wbr/><b>西外大街<\/b>/<wbr/><b>Xi Wai Da Jie<\/b>/<wbr/><b>W 2nd Ring<\/b>/<wbr/><b>西二环<\/b>/<wbr/><b>Xi Er Huan<\/b>/<wbr/><b>Xizhimen Brg<\/b>/<wbr/><b>西直门桥<\/b>/<wbr/><b>Xi Zhi Men Qiao<\/b>","maneuver":"ramp-left","polyline":{"points":"}}xrFsw{dUz@MPCf@CbAG|BGn@CVAbACd@C@?ZEh@ObA[r@_@JIJI`@[PQRSJMFGFIZe@DIp@kAb@eA@Cz@wCd@aBzAsF^qABK\\oAXoAh@_B"},"start_location":{"lat":39.94607,"lng":116.30986},"travel_mode":"DRIVING"},{"distance":{"text":"0.8 公里","value":789},"duration":{"text":"1分钟","value":47},"end_location":{"lat":39.93877,"lng":116.32545},"html_instructions":"走<b>紫竹院路<\/b>","maneuver":"merge","polyline":{"points":"yvwrFa`}dUVoAN_AF_@DYBQFg@V{BRgCDo@D{@F_B@YF}A@m@@S@Y@o@Bm@BaADiAF}BB{@HiCBkA@SDoAB{@Bm@Bo@"},"start_location":{"lat":39.93981,"lng":116.31633},"travel_mode":"DRIVING"},{"distance":{"text":"2.3 公里","value":2273},"duration":{"text":"2分钟","value":133},"end_location":{"lat":39.94007999999999,"lng":116.35172},"html_instructions":"继续前行，上<b>西外大街<\/b>","polyline":{"points":"ipwrFay~dU@U?E?Q@SB_A?IBm@HyB@Q?Q@I@SJyDDwANgEFmB@Q@_@Dw@DgAFaBDsABk@?SJmC@_@@]FgB@W@s@@wA@aBAaB?iACcBAeACcAG{DAw@KuDCwAAkACkAAcAAg@GoD?[A]Ag@A_@AUAgAIwD?GG_ACe@KaBEa@Go@AQO_Ag@cCMk@u@yC_@eBIa@QeAEWAOQoAAIKoAAMIaAAUEg@Ek@CUIeAASKyAC["},"start_location":{"lat":39.93877,"lng":116.32545},"travel_mode":"DRIVING"},{"distance":{"text":"0.8 公里","value":848},"duration":{"text":"1分钟","value":65},"end_location":{"lat":39.94427,"lng":116.35814},"html_instructions":"下出口，前往<b>N 2nd Ring<\/b>/<wbr/><b>北二环<\/b>/<wbr/><b>Bei Er Huan<\/b>/<wbr/><b>Jishuitan Brg<\/b>/<wbr/><b>积水潭桥<\/b>/<wbr/><b>Ji Shui Tan Qiao<\/b>","maneuver":"ramp-right","polyline":{"points":"oxwrFg}ceU@M@MCk@?Q?Q?C?E?U?QAoA?MCw@C{@AQCs@Ag@E}A?EEy@?EKc@GMIq@IIEGEGEEIGAAKIIAc@KWC_@CU?oB@_@CUAMCk@IWGAA_@Mm@YUMIEUOEEUUa@g@MSS]GIIQKQEIIUUo@Oc@AE[aAIK"},"start_location":{"lat":39.94007999999999,"lng":116.35172},"travel_mode":"DRIVING"},{"distance":{"text":"3.1 公里","value":3135},"duration":{"text":"3分钟","value":185},"end_location":{"lat":39.94891,"lng":116.39376},"html_instructions":"走<b>二环<\/b>/<wbr/><b>北二环<\/b>","maneuver":"merge","polyline":{"points":"urxrFkeeeUw@sDc@uBMo@CMUoAc@gC]uB]mB]iBG_@y@oEa@qB_AgE[qAmA_Eu@_COg@e@uA]eAMc@YcA_@uAa@iBQy@EOAEAGKo@QmAScCCa@?EAS?E?EAIASCi@I_DAc@A}@EwBIqCAw@CmB?kB?IAm@?Q?e@?c@?g@AaI?K?G?IA}A?oA?KAoACeD@{@?mC@aBAqDCyHAqC?mCAmC?sAAqDAu@?uA?}AAkC?yB?a@?aAC{J?c@?I"},"start_location":{"lat":39.94427,"lng":116.35814},"travel_mode":"DRIVING"},{"distance":{"text":"1.6 公里","value":1606},"duration":{"text":"1分钟","value":89},"end_location":{"lat":39.94909,"lng":116.4126},"html_instructions":"靠<b>右<\/b>继续沿<b>二环<\/b>/<wbr/><b>北二环<\/b>行驶","maneuver":"keep-right","polyline":{"points":"uoyrF_dleU?O?I?O?_@As@?M?Q?MAiD?E?KAaJ?E?UAyB?}A?q@CiJCgOAsF?w@?y@?s@AkA?yAA{G?_AA{B?o@AqCCuF?q@CwC?IAqD"},"start_location":{"lat":39.94891,"lng":116.39376},"travel_mode":"DRIVING"},{"distance":{"text":"0.2 公里","value":244},"duration":{"text":"1分钟","value":14},"end_location":{"lat":39.9492079,"lng":116.4154595},"html_instructions":"靠<b>左<\/b>继续沿<b>二环<\/b>/<wbr/><b>北二环<\/b>/<wbr/><b>雍和宫桥<\/b>行驶<div style=\"font-size:0.9em\">目的地在右侧<\/div>","maneuver":"keep-left","polyline":{"points":"ypyrFwyoeUKaIEaC?KEkB"},"start_location":{"lat":39.94909,"lng":116.4126},"travel_mode":"DRIVING"}],"traffic_speed_entry":[],"via_waypoint":[]}]
     * overview_polyline : {"points":"m|bsFs}{dUtAMPC\\@h@LZAXGHCVa@LWNMn@UbAWp@A`CEb@E~@m@z@e@p@q@FS@e@?iB?mDxDA@qD?sAE}@G[`@ElGUx@CbKa@tEQ~BIh@b@NE~AKd@a@BrBPxRBjCZ`DHbGJlIZjYFrG@bFEpCAtB@vHF|@DRNb@PVPLNJPDh@?RC\\W`@m@Xe@j@mAbAyBz@gBPWn@o@TQz@_@nAg@lGUrCMdH]bEShCG~COvCQxBUfAWPIv@a@~@i@fA_Aj@q@`AoAb@{@tCkFvCuFnA{BbA_Bf@g@n@]XEtAMtE[nGa@lBO`Ec@rGu@fHw@d@EdCAjBAh@E~Ae@~ASfKwAlDa@nCOdI]vHUnI[zVq@dGOnAOx@GhGUhBG\\Eh@ObA[r@_@VSr@m@n@s@`@o@p@kAb@eA|@{C`CuIb@}Av@_Dh@_BVoAV_Bh@oEXwDL{CLyDf@gQXeJT{Hp@wSXuHPmFLqEByDAkDQiLMmFEcDOgJEaCM}G]iFIaAw@cEcAeEi@gCW}AS_BYiDm@oIB[C}@?q@EgDKiDKcDSq@Iq@IIKOOMMKm@Mw@GeC@u@Ey@MYImAg@{@i@w@}@a@q@c@w@q@oB[aAIK{AiHkAuGaBmJ{AaI{AyGyD}Lk@iBy@yC{@yDMw@QmAScCCg@AYGmASyJKiECyEAoBCyQA{AAaF@oFEkNCaOC{KEcXCeICySKql@CgOIqQA{DQcMEwB"}
     * summary : 二环/北二环
     * warnings : []
     * waypoint_order : []
     */

    private List<RoutesBean> routes;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<GeocodedWaypointsBean> getGeocoded_waypoints() {
        return geocoded_waypoints;
    }

    public void setGeocoded_waypoints(List<GeocodedWaypointsBean> geocoded_waypoints) {
        this.geocoded_waypoints = geocoded_waypoints;
    }

    public List<RoutesBean> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RoutesBean> routes) {
        this.routes = routes;
    }

    public static class GeocodedWaypointsBean {
        private String geocoder_status;
        private String place_id;
        private List<String> types;

        public String getGeocoder_status() {
            return geocoder_status;
        }

        public void setGeocoder_status(String geocoder_status) {
            this.geocoder_status = geocoder_status;
        }

        public String getPlace_id() {
            return place_id;
        }

        public void setPlace_id(String place_id) {
            this.place_id = place_id;
        }

        public List<String> getTypes() {
            return types;
        }

        public void setTypes(List<String> types) {
            this.types = types;
        }
    }

    public static class RoutesBean {
        /**
         * northeast : {"lat":39.9970333,"lng":116.4154595}
         * southwest : {"lat":39.93809,"lng":116.29752}
         */

        private BoundsBean bounds;
        private String copyrights;
        /**
         * points : m|bsFs}{dUtAMPC\@h@LZAXGHCVa@LWNMn@UbAWp@A`CEb@E~@m@z@e@p@q@FS@e@?iB?mDxDA@qD?sAE}@G[`@ElGUx@CbKa@tEQ~BIh@b@NE~AKd@a@BrBPxRBjCZ`DHbGJlIZjYFrG@bFEpCAtB@vHF|@DRNb@PVPLNJPDh@?RC\W`@m@Xe@j@mAbAyBz@gBPWn@o@TQz@_@nAg@lGUrCMdH]bEShCG~COvCQxBUfAWPIv@a@~@i@fA_Aj@q@`AoAb@{@tCkFvCuFnA{BbA_Bf@g@n@]XEtAMtE[nGa@lBO`Ec@rGu@fHw@d@EdCAjBAh@E~Ae@~ASfKwAlDa@nCOdI]vHUnI[zVq@dGOnAOx@GhGUhBG\Eh@ObA[r@_@VSr@m@n@s@`@o@p@kAb@eA|@{C`CuIb@}Av@_Dh@_BVoAV_Bh@oEXwDL{CLyDf@gQXeJT{Hp@wSXuHPmFLqEByDAkDQiLMmFEcDOgJEaCM}G]iFIaAw@cEcAeEi@gCW}AS_BYiDm@oIB[C}@?q@EgDKiDKcDSq@Iq@IIKOOMMKm@Mw@GeC@u@Ey@MYImAg@{@i@w@}@a@q@c@w@q@oB[aAIK{AiHkAuGaBmJ{AaI{AyGyD}Lk@iBy@yC{@yDMw@QmAScCCg@AYGmASyJKiECyEAoBCyQA{AAaF@oFEkNCaOC{KEcXCeICySKql@CgOIqQA{DQcMEwB
         */

        private OverviewPolylineBean overview_polyline;
        private String summary;
        /**
         * distance : {"text":"17.7 公里","value":17720}
         * duration : {"text":"23分钟","value":1404}
         * end_address : 中国北京市东城区蒋宅口雍和宫桥西北角（近快客） 邮政编码: 100011
         * end_location : {"lat":39.9492079,"lng":116.4154595}
         * start_address : 中国北京市海淀区未名北路X8W6+MMR 邮政编码: 100084
         * start_location : {"lat":39.9970333,"lng":116.310823}
         * steps : [{"distance":{"text":"0.1 公里","value":115},"duration":{"text":"1分钟","value":28},"end_location":{"lat":39.99601,"lng":116.31084},"html_instructions":"向<b>南<\/b>方向，前往<b>镜春路<\/b>","polyline":{"points":"m|bsFs}{dU\\Cv@IPC\\@RDTFL?LA"},"start_location":{"lat":39.9970333,"lng":116.310823},"travel_mode":"DRIVING"},{"distance":{"text":"0.5 公里","value":510},"duration":{"text":"2分钟","value":133},"end_location":{"lat":39.99298,"lng":116.31392},"html_instructions":"继续前行，上<b>未名北路<\/b>","polyline":{"points":"avbsFw}{dUPCFCHCVa@LWNMRIZKn@QREB?l@ApBEN?^CBABAz@k@BCv@a@JGd@i@FS@e@?iA?_@AO@}C"},"start_location":{"lat":39.99601,"lng":116.31084},"travel_mode":"DRIVING"},{"distance":{"text":"0.1 公里","value":103},"duration":{"text":"1分钟","value":23},"end_location":{"lat":39.99205,"lng":116.31393},"html_instructions":"向<b>右<\/b>转，前往<b>大城坊<\/b>","maneuver":"turn-right","polyline":{"points":"ccbsF_q|dUP?fDA"},"start_location":{"lat":39.99298,"lng":116.31392},"travel_mode":"DRIVING"},{"distance":{"text":"0.2 公里","value":151},"duration":{"text":"1分钟","value":51},"end_location":{"lat":39.9921099,"lng":116.31569},"html_instructions":"在第 1 个交叉路口向<b>左<\/b>转，进入<b>大城坊<\/b>","maneuver":"turn-left","polyline":{"points":"i}asFaq|dU?W@yC?sAE}@G["},"start_location":{"lat":39.99205,"lng":116.31393},"travel_mode":"DRIVING"},{"distance":{"text":"0.6 公里","value":609},"duration":{"text":"2分钟","value":93},"end_location":{"lat":39.98665,"lng":116.31616},"html_instructions":"向<b>右<\/b>急转，进入<b>中关村北大街<\/b>","maneuver":"turn-sharp-right","polyline":{"points":"u}asFa||dU`@ER?xFUR?d@Cj@ChDOjBI`AC|@EhACt@EVAVAv@CPA\\A"},"start_location":{"lat":39.9921099,"lng":116.31569},"travel_mode":"DRIVING"},{"distance":{"text":"0.1 公里","value":116},"duration":{"text":"1分钟","value":30},"end_location":{"lat":39.98569,"lng":116.31624},"html_instructions":"向<b>右<\/b>转，进入<b>海淀路<\/b> （<b>N 4th Ring<\/b>/<wbr/><b>北四环<\/b>/<wbr/><b>Bei Si Huan<\/b>/<wbr/><b>Haidian Brg<\/b>/<wbr/><b>海淀桥<\/b>/<wbr/><b>Hai Dian Qiao<\/b>的路标）","maneuver":"turn-right","polyline":{"points":"q{`sF__}dUh@b@NEx@Ed@ENMTS"},"start_location":{"lat":39.98665,"lng":116.31616},"travel_mode":"DRIVING"},{"distance":{"text":"0.4 公里","value":379},"duration":{"text":"1分钟","value":67},"end_location":{"lat":39.98556,"lng":116.31179},"html_instructions":"向<b>右<\/b>急转，进入<b>北四环西路辅路<\/b>","maneuver":"turn-sharp-right","polyline":{"points":"qu`sFo_}dU@dA@l@@|AJhK@zA@t@BjC"},"start_location":{"lat":39.98569,"lng":116.31624},"travel_mode":"DRIVING"},{"distance":{"text":"71 米","value":71},"duration":{"text":"1分钟","value":9},"end_location":{"lat":39.98542,"lng":116.31098},"html_instructions":"走<b>左侧<\/b>匝道，前往<b>N 4th Ring W Rd<\/b>/<wbr/><b>北四环西路<\/b>/<wbr/><b>Bei Si Huan Xi Lu<\/b>","maneuver":"ramp-left","polyline":{"points":"wt`sFuc|dUZ`D"},"start_location":{"lat":39.98556,"lng":116.31179},"travel_mode":"DRIVING"},{"distance":{"text":"0.1 公里","value":130},"duration":{"text":"1分钟","value":7},"end_location":{"lat":39.98536,"lng":116.30946},"html_instructions":"走<b>北四环<\/b>/<wbr/><b>北四环西路<\/b>/<wbr/><b>四环<\/b>","maneuver":"merge","polyline":{"points":"{s`sFs~{dUFnE@r@@j@"},"start_location":{"lat":39.98542,"lng":116.31098},"travel_mode":"DRIVING"},{"distance":{"text":"0.5 公里","value":484},"duration":{"text":"1分钟","value":26},"end_location":{"lat":39.9851699,"lng":116.30379},"html_instructions":"靠<b>左<\/b>继续沿<b>北四环<\/b>/<wbr/><b>北四环西路<\/b>/<wbr/><b>四环<\/b>/<wbr/><b>海淀桥<\/b>行驶","maneuver":"keep-left","polyline":{"points":"os`sFcu{dUF`F?\\@`@?FL|K?L@^?\\@|@@r@FfF"},"start_location":{"lat":39.98536,"lng":116.30946},"travel_mode":"DRIVING"},{"distance":{"text":"0.2 公里","value":215},"duration":{"text":"1分钟","value":11},"end_location":{"lat":39.98511999999999,"lng":116.30127},"html_instructions":"靠<b>左<\/b>继续沿<b>万泉河桥<\/b>/<wbr/><b>北四环<\/b>/<wbr/><b>北四环西路<\/b>/<wbr/><b>四环<\/b>行驶","maneuver":"keep-left","polyline":{"points":"ir`sFuqzdU@`BDpD@pB?pB"},"start_location":{"lat":39.9851699,"lng":116.30379},"travel_mode":"DRIVING"},{"distance":{"text":"0.8 公里","value":756},"duration":{"text":"1分钟","value":54},"end_location":{"lat":39.98189,"lng":116.30041},"html_instructions":"下出口，前往<b>W 3rd Ring<\/b>/<wbr/><b>西三环<\/b>/<wbr/><b>Xi San Huan<\/b>/<wbr/><b>Suzhou Brg<\/b>/<wbr/><b>苏州桥<\/b>/<wbr/><b>Su Zhou Qiao<\/b>/<wbr/><b>Wanquanhe Rd<\/b>/<wbr/><b>万泉河路<\/b>/<wbr/><b>Wan Quan He Lu<\/b>","maneuver":"ramp-right","polyline":{"points":"_r`sF}azdUC|@?\\?FAl@An@?V?T?V@`@?V?jF?P@X?@@JBTBJ@FDPHP@@BDBDFHHFFDNJPDD@b@ARCDCFEHGDEBCHMJOFKNUHOLY\\s@Re@Te@Te@BGx@eB@ADIJMFGHIPQJKTQz@_@b@Qj@U"},"start_location":{"lat":39.98511999999999,"lng":116.30127},"travel_mode":"DRIVING"},{"distance":{"text":"2.6 公里","value":2625},"duration":{"text":"3分钟","value":164},"end_location":{"lat":39.9602,"lng":116.30833},"html_instructions":"走<b>万泉河路<\/b>","maneuver":"merge","polyline":{"points":"y}_sFq|ydUPAB?nDMfAEfAGb@AJAZAp@ETAb@Cf@CbAEb@C`@CF?ZCxBK\\ANAfAEL?`@AP?vAGRANAb@CfAGVCn@EF?h@EJAHATCJAJADADAB?bAWHEFCRIb@WVMf@[\\Yh@e@j@q@X_@f@o@HQXi@l@gA@CT_@nA_Cl@gAbAmBBE`@y@DI`@q@LSXk@LUDEJQb@q@DGHIHILKVOVMDARCVE|@G|@IvCQF?rBKfAIjAKd@EfAIlAKrBWx@IRCv@KlC[h@GbBQ\\EDAb@EVE^EXC\\CFAFA|B?pA?XAJA\\CVGfA]"},"start_location":{"lat":39.98189,"lng":116.30041},"travel_mode":"DRIVING"},{"distance":{"text":"1.6 公里","value":1578},"duration":{"text":"2分钟","value":96},"end_location":{"lat":39.94607,"lng":116.30986},"html_instructions":"继续前行，上<b>三环<\/b>/<wbr/><b>西三环<\/b>/<wbr/><b>西三环北路<\/b>","polyline":{"points":"gv{rFan{dUbAMZElBW~Cc@XE~AUd@GfCYhBKd@CXCNA`DMxBItBIb@ApCIJ?J?JAxAG|EQjAEpAExDKpDKVAh@AdDIH?nAEv@C^A|ACRA"},"start_location":{"lat":39.9602,"lng":116.30833},"travel_mode":"DRIVING"},{"distance":{"text":"1.0 公里","value":983},"duration":{"text":"1分钟","value":79},"end_location":{"lat":39.93981,"lng":116.31633},"html_instructions":"下<b>左侧<\/b>出口，前往<b>Xiwai Ave<\/b>/<wbr/><b>西外大街<\/b>/<wbr/><b>Xi Wai Da Jie<\/b>/<wbr/><b>W 2nd Ring<\/b>/<wbr/><b>西二环<\/b>/<wbr/><b>Xi Er Huan<\/b>/<wbr/><b>Xizhimen Brg<\/b>/<wbr/><b>西直门桥<\/b>/<wbr/><b>Xi Zhi Men Qiao<\/b>","maneuver":"ramp-left","polyline":{"points":"}}xrFsw{dUz@MPCf@CbAG|BGn@CVAbACd@C@?ZEh@ObA[r@_@JIJI`@[PQRSJMFGFIZe@DIp@kAb@eA@Cz@wCd@aBzAsF^qABK\\oAXoAh@_B"},"start_location":{"lat":39.94607,"lng":116.30986},"travel_mode":"DRIVING"},{"distance":{"text":"0.8 公里","value":789},"duration":{"text":"1分钟","value":47},"end_location":{"lat":39.93877,"lng":116.32545},"html_instructions":"走<b>紫竹院路<\/b>","maneuver":"merge","polyline":{"points":"yvwrFa`}dUVoAN_AF_@DYBQFg@V{BRgCDo@D{@F_B@YF}A@m@@S@Y@o@Bm@BaADiAF}BB{@HiCBkA@SDoAB{@Bm@Bo@"},"start_location":{"lat":39.93981,"lng":116.31633},"travel_mode":"DRIVING"},{"distance":{"text":"2.3 公里","value":2273},"duration":{"text":"2分钟","value":133},"end_location":{"lat":39.94007999999999,"lng":116.35172},"html_instructions":"继续前行，上<b>西外大街<\/b>","polyline":{"points":"ipwrFay~dU@U?E?Q@SB_A?IBm@HyB@Q?Q@I@SJyDDwANgEFmB@Q@_@Dw@DgAFaBDsABk@?SJmC@_@@]FgB@W@s@@wA@aBAaB?iACcBAeACcAG{DAw@KuDCwAAkACkAAcAAg@GoD?[A]Ag@A_@AUAgAIwD?GG_ACe@KaBEa@Go@AQO_Ag@cCMk@u@yC_@eBIa@QeAEWAOQoAAIKoAAMIaAAUEg@Ek@CUIeAASKyAC["},"start_location":{"lat":39.93877,"lng":116.32545},"travel_mode":"DRIVING"},{"distance":{"text":"0.8 公里","value":848},"duration":{"text":"1分钟","value":65},"end_location":{"lat":39.94427,"lng":116.35814},"html_instructions":"下出口，前往<b>N 2nd Ring<\/b>/<wbr/><b>北二环<\/b>/<wbr/><b>Bei Er Huan<\/b>/<wbr/><b>Jishuitan Brg<\/b>/<wbr/><b>积水潭桥<\/b>/<wbr/><b>Ji Shui Tan Qiao<\/b>","maneuver":"ramp-right","polyline":{"points":"oxwrFg}ceU@M@MCk@?Q?Q?C?E?U?QAoA?MCw@C{@AQCs@Ag@E}A?EEy@?EKc@GMIq@IIEGEGEEIGAAKIIAc@KWC_@CU?oB@_@CUAMCk@IWGAA_@Mm@YUMIEUOEEUUa@g@MSS]GIIQKQEIIUUo@Oc@AE[aAIK"},"start_location":{"lat":39.94007999999999,"lng":116.35172},"travel_mode":"DRIVING"},{"distance":{"text":"3.1 公里","value":3135},"duration":{"text":"3分钟","value":185},"end_location":{"lat":39.94891,"lng":116.39376},"html_instructions":"走<b>二环<\/b>/<wbr/><b>北二环<\/b>","maneuver":"merge","polyline":{"points":"urxrFkeeeUw@sDc@uBMo@CMUoAc@gC]uB]mB]iBG_@y@oEa@qB_AgE[qAmA_Eu@_COg@e@uA]eAMc@YcA_@uAa@iBQy@EOAEAGKo@QmAScCCa@?EAS?E?EAIASCi@I_DAc@A}@EwBIqCAw@CmB?kB?IAm@?Q?e@?c@?g@AaI?K?G?IA}A?oA?KAoACeD@{@?mC@aBAqDCyHAqC?mCAmC?sAAqDAu@?uA?}AAkC?yB?a@?aAC{J?c@?I"},"start_location":{"lat":39.94427,"lng":116.35814},"travel_mode":"DRIVING"},{"distance":{"text":"1.6 公里","value":1606},"duration":{"text":"1分钟","value":89},"end_location":{"lat":39.94909,"lng":116.4126},"html_instructions":"靠<b>右<\/b>继续沿<b>二环<\/b>/<wbr/><b>北二环<\/b>行驶","maneuver":"keep-right","polyline":{"points":"uoyrF_dleU?O?I?O?_@As@?M?Q?MAiD?E?KAaJ?E?UAyB?}A?q@CiJCgOAsF?w@?y@?s@AkA?yAA{G?_AA{B?o@AqCCuF?q@CwC?IAqD"},"start_location":{"lat":39.94891,"lng":116.39376},"travel_mode":"DRIVING"},{"distance":{"text":"0.2 公里","value":244},"duration":{"text":"1分钟","value":14},"end_location":{"lat":39.9492079,"lng":116.4154595},"html_instructions":"靠<b>左<\/b>继续沿<b>二环<\/b>/<wbr/><b>北二环<\/b>/<wbr/><b>雍和宫桥<\/b>行驶<div style=\"font-size:0.9em\">目的地在右侧<\/div>","maneuver":"keep-left","polyline":{"points":"ypyrFwyoeUKaIEaC?KEkB"},"start_location":{"lat":39.94909,"lng":116.4126},"travel_mode":"DRIVING"}]
         * traffic_speed_entry : []
         * via_waypoint : []
         */

        private List<LegsBean> legs;
        private List<?> warnings;
        private List<?> waypoint_order;

        public BoundsBean getBounds() {
            return bounds;
        }

        public void setBounds(BoundsBean bounds) {
            this.bounds = bounds;
        }

        public String getCopyrights() {
            return copyrights;
        }

        public void setCopyrights(String copyrights) {
            this.copyrights = copyrights;
        }

        public OverviewPolylineBean getOverview_polyline() {
            return overview_polyline;
        }

        public void setOverview_polyline(OverviewPolylineBean overview_polyline) {
            this.overview_polyline = overview_polyline;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public List<LegsBean> getLegs() {
            return legs;
        }

        public void setLegs(List<LegsBean> legs) {
            this.legs = legs;
        }

        public List<?> getWarnings() {
            return warnings;
        }

        public void setWarnings(List<?> warnings) {
            this.warnings = warnings;
        }

        public List<?> getWaypoint_order() {
            return waypoint_order;
        }

        public void setWaypoint_order(List<?> waypoint_order) {
            this.waypoint_order = waypoint_order;
        }

        public static class BoundsBean {
            /**
             * lat : 39.9970333
             * lng : 116.4154595
             */

            private NortheastBean northeast;
            /**
             * lat : 39.93809
             * lng : 116.29752
             */

            private SouthwestBean southwest;

            public NortheastBean getNortheast() {
                return northeast;
            }

            public void setNortheast(NortheastBean northeast) {
                this.northeast = northeast;
            }

            public SouthwestBean getSouthwest() {
                return southwest;
            }

            public void setSouthwest(SouthwestBean southwest) {
                this.southwest = southwest;
            }

            public static class NortheastBean {
                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }

            public static class SouthwestBean {
                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }
        }

        public static class OverviewPolylineBean {
            private String points;

            public String getPoints() {
                return points;
            }

            public void setPoints(String points) {
                this.points = points;
            }
        }

        public static class LegsBean {
            /**
             * text : 17.7 公里
             * value : 17720
             */

            private DistanceBean distance;
            /**
             * text : 23分钟
             * value : 1404
             */

            private DurationBean duration;
            private String end_address;
            /**
             * lat : 39.9492079
             * lng : 116.4154595
             */

            private EndLocationBean end_location;
            private String start_address;
            /**
             * lat : 39.9970333
             * lng : 116.310823
             */

            private StartLocationBean start_location;
            /**
             * distance : {"text":"0.1 公里","value":115}
             * duration : {"text":"1分钟","value":28}
             * end_location : {"lat":39.99601,"lng":116.31084}
             * html_instructions : 向<b>南</b>方向，前往<b>镜春路</b>
             * polyline : {"points":"m|bsFs}{dU\\Cv@IPC\\@RDTFL?LA"}
             * start_location : {"lat":39.9970333,"lng":116.310823}
             * travel_mode : DRIVING
             */

            private List<StepsBean> steps;
            private List<?> traffic_speed_entry;
            private List<?> via_waypoint;

            public DistanceBean getDistance() {
                return distance;
            }

            public void setDistance(DistanceBean distance) {
                this.distance = distance;
            }

            public DurationBean getDuration() {
                return duration;
            }

            public void setDuration(DurationBean duration) {
                this.duration = duration;
            }

            public String getEnd_address() {
                return end_address;
            }

            public void setEnd_address(String end_address) {
                this.end_address = end_address;
            }

            public EndLocationBean getEnd_location() {
                return end_location;
            }

            public void setEnd_location(EndLocationBean end_location) {
                this.end_location = end_location;
            }

            public String getStart_address() {
                return start_address;
            }

            public void setStart_address(String start_address) {
                this.start_address = start_address;
            }

            public StartLocationBean getStart_location() {
                return start_location;
            }

            public void setStart_location(StartLocationBean start_location) {
                this.start_location = start_location;
            }

            public List<StepsBean> getSteps() {
                return steps;
            }

            public void setSteps(List<StepsBean> steps) {
                this.steps = steps;
            }

            public List<?> getTraffic_speed_entry() {
                return traffic_speed_entry;
            }

            public void setTraffic_speed_entry(List<?> traffic_speed_entry) {
                this.traffic_speed_entry = traffic_speed_entry;
            }

            public List<?> getVia_waypoint() {
                return via_waypoint;
            }

            public void setVia_waypoint(List<?> via_waypoint) {
                this.via_waypoint = via_waypoint;
            }

            public static class DistanceBean {
                private String text;
                private int value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class DurationBean {
                private String text;
                private int value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class EndLocationBean {
                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }

            public static class StartLocationBean {
                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }

            public static class StepsBean {
                /**
                 * text : 0.1 公里
                 * value : 115
                 */

                private DistanceBean distance;
                /**
                 * text : 1分钟
                 * value : 28
                 */

                private DurationBean duration;
                /**
                 * lat : 39.99601
                 * lng : 116.31084
                 */

                private EndLocationBean end_location;
                private String html_instructions;
                /**
                 * points : m|bsFs}{dU\Cv@IPC\@RDTFL?LA
                 */

                private PolylineBean polyline;
                /**
                 * lat : 39.9970333
                 * lng : 116.310823
                 */

                private StartLocationBean start_location;
                private String travel_mode;

                public DistanceBean getDistance() {
                    return distance;
                }

                public void setDistance(DistanceBean distance) {
                    this.distance = distance;
                }

                public DurationBean getDuration() {
                    return duration;
                }

                public void setDuration(DurationBean duration) {
                    this.duration = duration;
                }

                public EndLocationBean getEnd_location() {
                    return end_location;
                }

                public void setEnd_location(EndLocationBean end_location) {
                    this.end_location = end_location;
                }

                public String getHtml_instructions() {
                    return html_instructions;
                }

                public void setHtml_instructions(String html_instructions) {
                    this.html_instructions = html_instructions;
                }

                public PolylineBean getPolyline() {
                    return polyline;
                }

                public void setPolyline(PolylineBean polyline) {
                    this.polyline = polyline;
                }

                public StartLocationBean getStart_location() {
                    return start_location;
                }

                public void setStart_location(StartLocationBean start_location) {
                    this.start_location = start_location;
                }

                public String getTravel_mode() {
                    return travel_mode;
                }

                public void setTravel_mode(String travel_mode) {
                    this.travel_mode = travel_mode;
                }

                public static class DistanceBean {
                    private String text;
                    private int value;

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public int getValue() {
                        return value;
                    }

                    public void setValue(int value) {
                        this.value = value;
                    }
                }

                public static class DurationBean {
                    private String text;
                    private int value;

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public int getValue() {
                        return value;
                    }

                    public void setValue(int value) {
                        this.value = value;
                    }
                }

                public static class EndLocationBean {
                    private double lat;
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }

                public static class PolylineBean {
                    private String points;

                    public String getPoints() {
                        return points;
                    }

                    public void setPoints(String points) {
                        this.points = points;
                    }
                }

                public static class StartLocationBean {
                    private double lat;
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }
            }
        }
    }
}
