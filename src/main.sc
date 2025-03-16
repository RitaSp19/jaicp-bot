require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём?
        script:
            $session.result = 0
        buttons:
            "Поехали" -> /question_1
            

    state: question_1
        a: В какой из экспедиций именинница ни разу не была?
        buttons:
            "археологическая" -> /1_wrong
            "фольклорная" -> /1_wrong
            "диалектологическая" -> /1_wrong
            "археографическая" -> /1_right
    
    state: 1_wrong
        a: Ответ записан!
        go!: question_2
        
    state: 1_right
        a: Ответ записан!
        script:
            $session.result = $session.result + 1;
        go!: question_2
    
    state: question_2
        a: Занятия какого из петербургских университетов именинница не посещала ни разу?
        buttons:
            "СПбГУ" -> /2_wrong
            "ВШЭ" -> /2_right
            "РГПУ" -> /2_wrong
            "ЕУ" -> /2_wrong
    
    state: 2_wrong
        a: Ответ записан!
        go!: question_3
        
    state: 2_right
        a: Ответ записан!
        script:
            $session.result = $session.result + 1;
        go!: question_3
    
    state: question_3
        a: {{$session.result}}