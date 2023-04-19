/** 멤버십 서비스에 필요한 기초 데이터 스크립트 **/

/* 멤버십 정보 */
INSERT INTO TB_MBSP (MBSP_ID, MBSP_NM, STATUS, MBSP_INFO, MBSP_IMG_URL, HOMEPAGE_URL, BIGO, INSERT_DATE, INSERT_USER)
    VALUES('M230227000001', '올리브영 멤버십', '1', '일반회원 - 5% 할인', 'http://franc.img.com/img/olive_msp.jpg', 'https://oliveyoung.co.kr', '', NOW(), 1);
INSERT INTO TB_MBSP (MBSP_ID, MBSP_NM, STATUS, MBSP_INFO, MBSP_IMG_URL, HOMEPAGE_URL, BIGO, INSERT_DATE, INSERT_USER)
    VALUES('M230227000002', 'CU 멤버십', '1', '일반회원 - 결제금액의 10% 적립', 'http://franc.img.com/img/cu_msp.jpg', 'https://cu.bgretail.com', '', NOW(), 1);
INSERT INTO TB_MBSP (MBSP_ID, MBSP_NM, STATUS, MBSP_INFO, MBSP_IMG_URL, HOMEPAGE_URL, BIGO, INSERT_DATE, INSERT_USER)
    VALUES('M230227000003', 'GS 멤버십', '1', '일반회원 - 결제금액의 10% 할인', 'http://franc.img.com/img/gs_msp.jpg', 'https://www.gsretail.com', '', NOW(), 1);