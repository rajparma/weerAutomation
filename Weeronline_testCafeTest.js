import { Selector, ClientFunction } from 'testcafe';


 fixture `Getting Started`
    .page `https://www.weeronline.nl/`
    .afterEach(async t => {
        await t.eval(() => localStorage.clear());
    });

     test('verify_Searched_City_Page_redirected', async t => {
        
               await t
               .click('.wol-acceptButton-module__button___eJm9c')
               .typeText('input[type="text"]', "Rotterdam")
               .click( Selector('.wol-suggestion-module__results___2Ltmh').child('div'))
               const getURL = await ClientFunction(() => window.location.href)()
               console.log(getURL)
              await t.expect(getURL).eql('https://www.weeronline.nl/Europa/Nederland/Rotterdam/4057931')
            
    }); 

    test('verify_URL_for_Weerbericht_Nederland_Page', async t => {
        
        await t
        .click('.wol-acceptButton-module__button___eJm9c')
        .hover(Selector('.wol-header-module__lgContainer___3qgem').child('.wol-headerMenu-module__menu___1ed6a').child('li'))
        .click( Selector('.wol-headerMenu-module__menu___1ed6a').child('li[class="wol-headerMenu-module__active___1nqA6"]').child('ul').child('li'))
        await t.wait(2000)
        const getURL = await ClientFunction(() => window.location.href)();
        console.log(getURL)
        await t.expect(getURL).eql('https://www.weeronline.nl/weerbericht-nederland')
     
}); 


test('verify_User_Sets_Homepage_City', async t => {
        
    await t
    .click('.wol-acceptButton-module__button___eJm9c')
    .typeText('input[type="text"]', "Rotterdam")
    .click( Selector('.wol-suggestion-module__results___2Ltmh').child('div'))
    .click( Selector('div[class = "wol-button-module__content___vCqsn"]').child('div[class="wol-button-module__link___3ej19 wol-DefaultLocationButton-module__btn___dJtnN"]'))
    await t.wait(3000)
    const goBack = ClientFunction(() => window.history.back())
    await goBack();

    await t.wait(3000)
    const expectText = Selector('div[class = "wol-pageTitle-module__pageTitle___vX8sV"]').child('h1').innerText
    await t.expect(expectText).eql("Rotterdam")
 }); 

