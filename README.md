# Kriegsspiel

1. создать id в виде кода который будет отправляться на фронт
и будет в тайне, по нему будет определятся какой игрок ходит
и нельзя будет обмануть походив не тому

2. проверить не возникнет ли проблем из-за того что можно 
создать сколько угодно игроков(сделал эту херню для возможности)
играть >2 игрокам

3. Убрать кучу if которые используются для проверки карты на
содержание в ней юнитов и на то ходит ли игрок в свою очередь
А если быть точнее там слишком много проверок но они должны
быть сделанны без if

4. добавить в игру таймер чтобы на выполнение хода у игрока
было определённое время

5. сделать возможность дальнего боя*

6. Добавить разные цели в игре

7. Каждый тип юнитов должен обладать своими уникальными 
особенностиями то есть функциями

8. Попробовать сделать присвоение unitType в видах войск
c помощью рефлексии и запизнуть это в родительский класс
чтобы не писать одно и тоже 

9. В GAMEMANAGER куча ифов мне это не нравится. Надо что-то
придумать но пока не горит.

10. В GameInformation публичные модификаторы доступа
это **наверное** не очень парвильно но мне кажется это 
наиболее удобным вариантом 

11. Добавить в GameMath возможность определения всего в 
зависимости от региона и совместить это со всем

12. Протестировать GameMath

13. В GameManager в fillMapUnitsBy юниты расставляются 
случайным образом и нельзя точно опрределить сложность
этого алгоритма так как если есть юнит в этой координате
то юнит ставится в новую рандомную точку

14. Сделать объединение армий

15. Возможно стоить начальное заполнение поля сделать в 
отдельномо классе **но это не точно**

16. Добавить с помощью GameMath различную дистанцию 
перемещения

17. Сделать более адекватный способо подсчёта урона и тд
Нужно сделать баланс в игре. Для этого надо изсенить
GameMath

18. Добавить регионы в которые не может переместиться 
какой-нибудь тип юнитов

19. Есть класс GameConstant и мне кажется что это лютый 
костыль, так что либо проверить есть ли это костыль или
исправить

## Быстрые заметки на время разработки
первое время планирую не включать регионы

есть некая особеность при вводе имён они потом вытаскиваются
из карты с помощью итератора и не понятно какое имя будет пе
рвым. Возможно из-за этого не очень понятно какой игрок будет
делать первый ход. Возможна уязвимость что игрок правильно 
подобравший имя будет всегда ходить первый

keySet имён вытаскивается итератором и запушивается в очерредь
где имена движутся по кругу

После некоторых действий будет передаваться
ход после некотрыйх не будет

пока юниты не атакуют без передвижения

пока за один ход может пойти только один отряд

после перемещения мы получаем информацию о том куда 
переместился отряд и если было столкновение с противником
показвыает что произошло 

GameInformation отправляется на фронт и потом по этой 
информации создаётся ui

GameInformation{
    информация о своих юнитах с учётом плохой связи
    информация о враге доступная
}

#### действия:
- вернуть инормация о местности вокруг юнитов
- перейти(или атаковать) отряду на конкретную позицию
 **(передача хода)**

## Описание
### Принцип работы
### Команды на сервер
Команды передаются с помощью контроллера и разбиты на 2 этапа
- 1 этап это ввод никнеёмов игроками обмен ключами т тд.
- 2 этап это управление игрой

Контроллер называется PlayController 

#### методы
в классе GameManager меотод move. Сначала куча if-ов для
различных проверок. Потом циклом находи во вражеском
Player нужного юнита и удаляем его. Потом Тоже самое 
делаем с своим Player.Потом получаем юнита который получится
в результате и добавляем его на карту. Удаляем с карты
старых юнитов. Добавляем в Player того кто победил в битве
этого юнита.    
#### Пометки для лучшего понимания
В классе GameMath все методы статичные. В нём считается:
- урон нанесённый тем или иным отрядом
- Урон полученный тем или иным отрядом
- шанс того что информация не дойдёт от того или иного отряда

### Правила игры
Цель уничтожить все вражеские войска(пока) потом будут разные цели

Пока за один ход ходит один отряд

Пока каждому игроку даются 7 пехоты и 4 танка

Пока расположение войск случайно

При столкновении двух групп юнитов,
обедит та группа у которой больше боевая мощь

Боевая мощь определяется как произведение силы на число
юнитов(переписать надо будет после регионов)

Пока если боевые мощи равны то поюедит атакующий

Победители остаются в следующем колличестве:
round(колличество юнитов - кол.юнитов\*0,01\*(силу(врагов)/защиту
/*0.1))
### Коммиты
Коммит делается так:
- сначала номер задачи, если дополнение не предполагаетзадачу
 то цифра "0"
- имя разработчика
- краткое описание

Знак рааздеоитель между пунктаами "-"
   
**Пример:**
 
    3423-odin-create_map
