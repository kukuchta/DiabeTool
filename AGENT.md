Wymagania:

1. Ekran główny
   1.1 Wykres główny
- Na środku ekranu musi znajdować się wykres główny
- Wykres musi pokazywać dane z ostatnich 24h
- Wykres musi być skalowalny w osi poziomej przy użyciu gestów
- Na osi poziomej muszą znajdować się zaznaczone pełne godziny, od 00 do 23
- Pionowe linie siatki na wykresie muszą znajdować się na pełnych godzinach
- Na osi pionowej muszą znajdować się wartości glukozy w mg/dl, od 0, co 50
- Poziome linie siatki na wykresie muszą znajdować się co 50 mg/dl
- Górny zakres wartości na osi pionowej musi być dobierany automatycznie, tak, żeby zawsze był o 50 mg/dl większy od najwyższego wskazania glukozy spośród wszystkich wyświetlanych danych (z ostatnich 24h)
- Poniżej wykresu musi się znajdować miniatura wykresu głównego
- Miniatura musi zawsze pokazywać dane z całych 24h
- Miniatura musi być zsynchronizowana z wykresem głównym i pokazywać który fragment danych jest aktualnie widoczny na wykresie głównym
- Wszystkie kolory użyte na wykresie muszą być konfigurowalne

1.1.1 Dane o glukozie
- Dane na wykresie głównym muszą zawierać poziom glukozy w zakresie maksymalnie 40-400 mg/dl
- Dane muszą być wyświetlane w postaci kropek w jednym z trzech kolorów, dla danych w zakresie, poniżej zakresu i powyżej zakresu
- Na wykresie musi być zaznaczona pozioma linia oznaczająca zakres dolny
- Obszar wykresu poniżej zakresu dolnego musi być wypełniony konfigurowalnym kolorem (z przezroczystością)
- Na wykresie musi być zaznaczona pozioma linia oznaczająca zakres górny
- Po przytrzymaniu palcem na wykresie musi pojawić się kursor wskazujący najbliższą wartość glukozy
- Nad kursorem musi pojawić się informacja o wskazywanym czasie i odpowiadającej wartości glukozy
- Linia łącząca poszczególne wartości glukozy musi być wyświetlona w formie spline łączącego punkty średnie pomiędzy każdymi kolejnymi dwoma wartościami, nie musi łączyć samych wartości
- W przypadku gdy przerwa czasowa pomiędzy dwoma wartościami wynosi więcej niż 7 minut nie wyznaczamy punktu średniego i nie łączymy z nim linii łączącej pozostałe dane
- Dane o glukozie pochodzą z odpowiedzi na zapytania wysyłane przez kolektor

1.1.2 Dane o posiłkach
- Dane na wykresie głównym muszą zawierać informację o posiłkach
- Posiłek musi być oznaczony ikoną oraz stale widocznym polem tekstowym z wartością całkowitą wyrażoną w gramach (np. 12g)
- Ikony posiłków powinny się znajdować na stałej, konfigurowalnej wysokości od dołu wykresu głównego
- W przypadku gdy ikony są blisko siebie i pola z wartościami nakładają się na siebie, należy ustawić pola jedno nad drugim, najwcześniejsze na górze
- Dane o posiłkach mogą pochodzić z odpowiedzi na zapytania wysyłane przez kolektor lub być dodawane ręcznie

1.1.3 Dane o bolusach
- Dane na wykresie głównym muszą zawierać informację o bolusach
- Bolus musi być oznaczony ikoną oraz stale widocznym polem tekstowym z wartością ułamkową wyrażoną w jednostkach (np. 12.5j)
- Liczba wyświetlanych miejsc po przecinku musi być zaokrąglona do maksymalnie 3 miejsc
- Ikony bolusów powinny się znajdować na stałej, konfigurowalnej wysokości od dołu wykresu głównego
- W przypadku gdy ikony są blisko siebie i pola z wartościami nakładają się na siebie, należy ustawić pola jedno nad drugim, najwcześniejsze na górze
- Dane o bolusach mogą pochodzić z odpowiedzi na zapytania wysyłane przez kolektor lub być dodawane ręcznie

1.1.4 Dane o powiadomieniach
- Dane na wykresie głównym muszą zawierać informację o powiadomieniach
- Powiadomienie musi być oznaczone ikoną
- Po kliknięciu na ikonę należy wyświetlić okienko z czasem i wartością przyporządkowaną do powiadomienia
- Ikony powiadomień mogą się różnić
- Ikony powiadomień powinny znajdować się na wykresie w konfigurowalnej odległości ponad najbliższą w czasie wartością glukozy
- Powiadomienia mogą pochodzić z odpowiedzi na zapytania wysyłane przez kolektor lub być dodawane ręcznie
- Powiadomienia muszą mieć zdefiniowany typ
- Podstawowe typy to notatka, zmiana wkłucia, zmiana sensora, informacja, ostrzeżenie, alarm

1.1.5 Dane o bazie
- Dane na wykresie głównym muszą opcjonalnie zawierać informację o insulinie bazowej
- Wykres musi mieć postać linii schodkowej, której poziom może się zmieniać co pół godziny począwszy od godziny 0, czyli o 0:00, 0:30, 1:00 itd
- Wykres musi mieć poziom zerowy na górnej krawędzi wykresu głównego
- Oś pionowa danych o bazie musi być odwrócona, wyższe wartości powodują że linia wykresu obniża się w kierunku dołu wykresu
- Obszar ponad wykresem bazy aż do górnej krawędzi wykresu głównego musi być wypełniony konfigurowalnym kolorem (z przezroczystością)
- Całkowity obszar zajmowany przez wykres danych o bazie jest konfigurowalny w procentach względem wysokości całego obszaru wykresu głównego
- Największa wartość bazy z wyświetlanych ostatnich 24h będzie zajmowała w pionie cały dostępny obszar danych o bazie
- Pozostałe wartości bazy muszą być skalowane według wartości największej
- Po przytrzymaniu linii wykresu bazy dla danego półgodzinnego zakresu czasu należy wyświetlić okienko z rzeczywistą, nieprzeskalowaną wartością bazy w tym czasie
- Dane o wartościach bazy są muszą być skonfigurowane dla całego, ciągłego przedziału czasu od 00:00 do 24:00, z podziałem na 30 minutowe sloty.
- Wartości są podawane z dokładnością do 0.025j
- Konfiguracja polega na ustaleniu dowolnie długiej listy przedziałów czasowych wraz z przypisaną wartością, np 00:00-00:30 (0.300j), 00:30-02:00 (0.475j) itd.

1.1.6 Dane o insulinie aktywnej
- Dane na wykresie głównym muszą zawierać informację o ilości insuliny aktywnej (IoB)
- Wykres musi mieć postać linii
- Wykres musi mieć poziom zerowy na dolnej krawędzi wykresu głównego
- Obszar pod wykresem insuliny aktywnej aż do dolnej krawędzi wykresu głównego musi być wypełniony konfigurowalnym kolorem (z przezroczystością)
- Całkowity obszar zajmowany przez wykres danych o insulinie aktywnej jest konfigurowalny w procentach względem wysokości całego obszaru wykresu głównego
- Największa wartość insuliny aktywnej z wyświetlanych ostatnich 24h będzie zajmowała w pionie cały dostępny obszar przeznaczony dla insuliny aktywnej
- Pozostałe wartości insuliny aktywnej muszą być skalowane według wartości największej
- Wartości muszą być obliczane na podstawie 3 konfigurowalnych parametrów A, B i C, oraz wartości i czasu od wszystkich bolusów i opcjonalnie wartości bazy, autokorekt i autobazy, wszystkie dane z ostatnich wyświetlanych 24h

1.1.7 Dane o aktywności insuliny
- Dane na wykresie głównym muszą zawierać informację o aktywności insuliny
- Wykres musi mieć postać linii
- Wykres musi mieć poziom zerowy na dolnej krawędzi wykresu głównego
- Obszar pod wykresem aktywności insuliny aż do dolnej krawędzi wykresu głównego musi być wypełniony konfigurowalnym kolorem (z przezroczystością)
- Całkowity obszar zajmowany przez wykres danych o aktywności insuliny jest konfigurowalny w procentach względem wysokości całego obszaru wykresu głównego
- Największa wartość aktywności insuliny z wyświetlanych ostatnich 24h będzie zajmowała w pionie cały dostępny obszar przeznaczony dla aktywności insuliny
- Pozostałe wartości aktywności insuliny muszą być skalowane według wartości największej
- Wartości muszą być obliczane na podstawie 3 konfigurowalnych parametrów D, E i F, oraz wartości i czasu od wszystkich bolusów i opcjonalnie wartości bazy, autokorekt i autobazy, wszystkie dane z ostatnich wyświetlanych 24h

1.1.8 Dane o automatycznych korektach
- Dane na wykresie głównym muszą opcjonalnie zawierać informację o automatycznych korektach
- Wykres musi mieć postać słupków występujących lub nie przy każdym odczycie glukozy (co 5 minut)
- Wykres musi mieć poziom zerowy na górnej krawędzi wykresu głównego
- Oś pionowa danych o bazie musi być odwrócona, wyższe wartości powodują że linia wykresu obniża się w kierunku dołu wykresu
- Słupki muszą mieć konfigurowalny kolor i obwódkę (z przezroczystością)
- Minimalna wysokość słupka musi być konfigurowalna procentowo względem obszaru wykresu głównego
- Maksymalna wysokość słupka musi być konfigurowalna procentowo względem obszaru wykresu głównego
- Wartości autokorekt z wyświetlanych ostatnich 24h muszą być przeskalowane, tak żeby minimalna i maksymalna wartość odpowiadała minimalnej i maksymalnej wysokości słupka
- Po przytrzymaniu danego słupka należy wyświetlić okienko z rzeczywistą, nieprzeskalowaną wartością autokorekty
- Wartości pochodzą z odpowiedzi na zapytania wysyłane przez kolektor

1.1.9 Dane o automatycznej bazie
- Dane na wykresie głównym muszą opcjonalnie zawierać informację o automatycznej bazie
- Wykres musi mieć postać słupków występujących lub nie przy każdym odczycie glukozy (co 5 minut)
- Wykres musi mieć poziom zerowy na górnej krawędzi wykresu głównego
- Oś pionowa danych o bazie musi być odwrócona, wyższe wartości powodują że linia wykresu obniża się w kierunku dołu wykresu
- Słupki muszą mieć konfigurowalny kolor i obwódkę (z przezroczystością)
- Minimalna wysokość słupka musi być konfigurowalna procentowo względem obszaru wykresu głównego
- Maksymalna wysokość słupka musi być konfigurowalna procentowo względem obszaru wykresu głównego
- Wartości autobazy z wyświetlanych ostatnich 24h muszą być przeskalowane, tak żeby minimalna i maksymalna wartość odpowiadała minimalnej i maksymalnej wysokości słupka
- Po przytrzymaniu danego słupka należy wyświetlić okienko z rzeczywistą, nieprzeskalowaną wartością autobazy
- Wartości pochodzą z odpowiedzi na zapytania wysyłane przez kolektor

1.1.10 Dane o pomiarach glukozy
- Dane na wykresie głównym muszą zawierać informację o pomiarach glukozy
- Wykres musi mieć postać kropek z obwódką o konfigurowalnych kolorach
- Kropki muszą być przesunięte na wykresie głównym o konfigurowalny czas w przyszłości względem rzeczywistego czasu pomiaru, domyślnie o 15 minut
- Po kliknięciu na pomiar należy wyświetlić okienko z wartością i czasem pomiaru
- Dane o pomiarach glukozy mogą pochodzić z odpowiedzi na zapytania wysyłane przez kolektor lub być dodawane ręcznie

1.2 Dane bieżące
- Ponad wykresem głównym muszą wyświetlać się dane bieżące:
    - Najnowsza wartość glukozy
    - Strzałka trendu
    - Czas od ostatniego odczytu glukozy
    - Zmiana względem poprzedniego odczytu glukozy
    - Czas poniżej zakresu
    - Czas w zakresie
    - Czas powyżej zakresu
    - Ilość insuliny aktywnej  (format: n.nnj)
    - Całkowita ilość węglowodanów w czasie ostatnich 24h lub od początku dnia (konfigurowalne) (format: ng)
    - Całkowita ilość insuliny (DDI) w czasie ostatnich 24h lub od początku dnia (konfigurowalne) (format: n.nnj)
    - Poziom baterii telefonu (format: n%)
    - Poziom baterii pompy (format: n%)
    - Czas od ostatniej zmiany sensora (format: d hh mm)
    - Czas od ostatniej zmiany wkłucia (format: d hh mm)
    - Ikona połączenia z sensorem
    - Ikona połączenia z pompą
- Obecność poszczególnych danych bieżących musi być konfigurowalna
- Poszczególne kolory wartości glukozy i innych danych bieżących muszą być konfigurowalne

1.2.1 Najnowsza wartość glukozy
- Kolor wartość glukozy musi zmieniać się w zależności od tego czy dana wartość jest poniżej, wewnątrz lub powyżej zakresu
- W przypadku kiedy czas od ostatniego odczytu glukozy jest większy niż konfigurowalny czas timeoutu wartość glukozy musi zostać przekreślona
- Jest to ta sama wartość która jest rejestrowana na wykresie glukozy

1.2.2 Strzałka trendu
- Strzałka trendu musi odzwierciedlać tempo zmiany wartości od ostatniego odczytu, może to być strzałka pozioma, strzałka w górę lub w dół, dwie strzałki w górę lub w dół, trzy strzałki w górę lub w dół
- Graniczne tempa zmian pomiędzy kolejnymi strzałkami musi być konfigurowalne w mg/dl/5minut

1.2.3 Czas i zmiana od ostatniego odczytu glukozy
- Czas od ostatniego odczytu glukozy musi być wyświetlany w minutach
- Zmiana musi być wyświetlana w formacie: +13 mg/dl lub -18 mg/dl
- W przypadku kiedy czas od ostatniego odczytu glukozy jest większy niż konfigurowalny czas timeoutu czas musi być wyświetlony na inny konfigurowalny kolor, a zmiana musi być zastąpiona napisem "Brak danych" w kolorze takim jak czas

1.2.4 Czasy w zakresie
- Czas w poniżej zakresu musi odzwierciedlać ilość odczytów glukozy znajdujących się pod linią zakresu dolnego w stosunku do wszystkich odczytów z ostatnich 24h lub od początku dnia (konfigurowalne)
- Czas w zakresie musi odzwierciedlać ilość odczytów glukozy znajdujących się pomiędzy liniami zakresu dolnego i górnego w stosunku do wszystkich odczytów z ostatnich 24h lub od początku dnia (konfigurowalne)
- Czas w powyżej zakresu musi odzwierciedlać ilość odczytów glukozy znajdujących się ponad linią zakresu górnego w stosunku do wszystkich odczytów z ostatnich 24h lub od początku dnia (konfigurowalne)

1.2.5 Ilość insuliny aktywnej  (format: n.nnj)
- Musi być obliczana na podstawie 3 konfigurowalnych parametrów A, B i C, oraz wartości i czasu od wszystkich bolusów i opcjonalnie wartości bazy, autokorekt i autobazy, wszystkie dane z ostatnich wyświetlanych 24h
- Jest to ta sama wartość która jest rejestrowana na wykresie insuliny aktywnej

1.2.6 Całkowita ilość węglowodanów
- Jest to w suma danych o posiłkach czasie ostatnich 24h lub od początku dnia (konfigurowalne)
- Musi być wyświetlana w formacie: 12 g

1.2.7 Całkowita ilość insuliny (DDI) w czasie ostatnich 24h lub od początku dnia (konfigurowalne) (format: n.nnj)
- Jest to w suma danych o bazie, bolusach, autobazie i autokorektach czasie ostatnich 24h lub od początku dnia (konfigurowalne)
- Musi być wyświetlana w formacie: 12.14 j

1.2.8 Poziom baterii pompy (format: n%)
- Wartość pochodzą z odpowiedzi na zapytania wysyłane przez kolektor
- Musi być wyświetlana w formacie: 12 %
- W przypadku kiedy czas od ostatniego odczytu z kolektora jest większy niż konfigurowalny czas timeoutu wartość musi zostać przekreślona

1.2.9 Czas od ostatniej zmiany sensora (format: d hh mm)
- Jest to czas jaki upłynął od ostatniego powiadomienia typu "zmiana sensora"
- W przypadku braku takiego powiadomienia należy wyświetlić "---"
- Musi być wyświetlana w formacie: "d dni hh godzin"

1.2.10 Czas od ostatniej zmiany wkłucia (format: d hh mm)
- Jest to czas jaki upłynął od ostatniego powiadomienia typu "zmiana wkłucia"
- W przypadku braku takiego powiadomienia należy wyświetlić "---"
- Musi być wyświetlana w formacie: "d dni hh godzin"

1.2.11 Ikona połączenia z sensorem
- W przypadku kiedy czas od ostatniego odczytu glukozy z kolektora jest mniejszy niż konfigurowalny czas timeoutu ikona musi mieć kolor zielony
- W pozostałych przypadkach ikona musi mieć kolor czerwony

1.2.12 Ikona połączenia z pompą
- W przypadku kiedy czas od ostatniego odczytu statusu połączenia z pompą z kolektora jest mniejszy niż konfigurowalny czas timeoutu ikona musi mieć kolor zielony
- W pozostałych przypadkach ikona musi mieć kolor czerwony

1.3 Dodawanie informacji
- Na ekranie musi być dostępny przycisk ręcznego dodawania informacji
- Po kliknięciu na przycisk musi się otworzyć okienko z możliwością szybkiego wyboru typu informacji:
    - Posiłku
    - Bolusa
    - Pomiaru glukozy
    - Notatki
    - Zmiany wkłucia
    - Zmiany sensora
- Okienko musi umożliwiać wybór daty i czasu, domyślna wartość to data i czas bieżący
- Po wybraniu Posiłku należy wyświetlić pole do wprowadzenia wartości całkowitej w g
- Po wybraniu Bolusa należy wyświetlić pole do wprowadzenia wartości ułamkowej w j
- Po wybraniu Pomiaru glukozy należy wyświetlić pole do wprowadzenia wartości całkowitej w mg/dl
- Po wybraniu Notatki glukozy należy wyświetlić pole do wprowadzenia wartości tekstowej, maksymalnie 200 znaków
- Po wybraniu Zmiany wkłucia lub sensora glukozy należy wyświetlić pole do wprowadzenia wartości tekstowej, maksymalnie 200 znaków
- Okienko musi zawierać przycisk Ok do zapisania informacji i Anuluj do cofnięcia do ekranu głównego bez zapisywania

2. Menu główne
- Menu główne musi zawierać pozycje:
    - Historia
    - Statystyka
    - Alarmy
    - Status
    - Kopia zapasowa
    - Ustawienia
    - O programie

3. Historia
- Ekran historii musi umożliwiać przeglądanie historycznych danych zarejestrowanych w programie:
    - o glukozie
    - o posiłkach
    - o bolusach
    - o powiadomieniach
    - o bazie
    - o automatycznych korektach
    - o automatycznej bazie
    - o pomiarach glukozy
- Musi mieć pole do wyboru bieżącej daty przeglądania
- Musi mieć dwa przyciski do przełączania na dzień poprzedni i kolejny
- Musi zawierać wykres taki sam jak wykres na ekranie głównym oraz taką samą zsynchronizowaną miniaturkę wykresu głównego
- Musi wyświetlać na wykresie dane historyczne dotyczące aktualnie wybranego jednego dnia

4. Statystyka
- Musi pokazywać kilka wartości statystycznych obliczonych na podstawie historycznych danych o glukozie
- Musi mieć możliwość wyboru okresu jakiego dotyczy statystyka - Dzień, 7 dni, 14 dni, 30 dni, 90 dni i od początku historii
- Musi wyświetlać datę i czas najstarszej informacji o glukozie, jako początek statystyki
- Musi zawierać wykres kołowy pokazujący czas poniżej, w i powyżej zakresu obliczony dla wybranego przedziału czasowego
- Po wybraniu przedziału Dzień należy wyświetlić kontrolki do wyboru konkretnej daty oraz przyciski przełączania na poprzedni i następny dzień. Domyślnym datą jest dzień poprzedni.

5. Alarmy
- Musi być możliwość ustawienia listy alarmów z różnymi warunkami zadziałania
- W oknie musi być wyświetlona lista ustawionych alarmów
- Musi być przycisk dodawania alarmu po którym wyświetli się okienko dodawania alarmu
- Musi być możliwość wybrania typu alarmu:
    - Przekroczenie progu x mg/dl
    - Spadek poniżej progu x mg/dl
    - Wzrost szybszy niż x mg/dl / 5 minut
    - Spadek szybszy niż x mg/dl / 5 minut
    - Utrzymanie powyżej progu x mg/dl przez y minut
    - Utrzymanie poniżej progu x mg/dl przez y minut
    - Brak danych przez x minut
- Musi być dostępne pole do wpisania odpowiednich wartości x i y
- Musi być możliwość określenia w jakim dobowym przedziale czasu dany alarm może zostać aktywowany
- Musi być możliwość określenia co jaki czas będzie odgrywany alarm jeżeli użytkownik go nie uśpi
- Musi być możliwość określenia po jakim czasie po uśpieniu przez użytkownika alarm znów będzie aktywowany (jeżeli warunki są nadal spełnione)
- Musi być możliwość określenia sygnału dźwiękowego dla danego alarmu
- Okienko musi zawierać przycisk Ok do zapisania alarmu i Anuluj do cofnięcia do listy alarmów bez zapisywania
- Każdy alarm można usunąć przytrzymując palcem i wybierając Usuń
- Każdy alarm można edytować przytrzymując palcem i wybierając Edytuj
- Każdy alarm można duplikować przytrzymując palcem i wybierając Duplikuj
- Aktywowany alarm musi odegrać dźwięk z największą dostępną w systemie głośnością, ignorując ustawienia użytkownika i tryb nie przeszkadzać
- Aktywowanie alarmów jest krytyczną funkcją programu, należy wykorzystać wszelkie dostępne mechanizmy aby zapewnić prawidłowe aktywowanie alarmów w odpowiedzi na bieżące dane otrzymywane z kolektora.

6. Status (+ logi)
- Musi wyświetlać bieżący status programu i logi (TBD)

7. Kopia zapasowa
- Musi zawierać mechanizm eksportowania i importowania wszystkich zapisanych danych historycznych
- Musi zawierać mechanizm eksportowania i importowania wszystkich ustawień programu w formie pliku json lub xml
- Opcjonalnie musi zawierać mechanizm eksportowania wszystkich ustawień jako tablicy danych zakodowanych w formie kodu QR oraz ich importowania z przygotowanego wcześniej kodu QR przy pomocy aparatu lub importu zdjęcia

8. Ustawienia
- Musi zawierać wszystkie wymagane parametry konfiguracyjne pogrupowane tematycznie
- Należy zapewnić mechanizm aktualizacji UI w reakcji na zmianę odpowiednich ustawień

9. Kolektory
- Program musi zapewnić mechanizm pewnego i krytycznego w czasie uruchamiania kolektorów danych z zadanym interwałem czasowym (domyślnie 5 minut)
- Możliwe jest używanie więcej niż jednego kolektora. Ich ilość i typ będą rozszerzalne, aby umożliwić zbieranie danych z różnych źródeł (przez API i w przyszłości opcjonalnie przez Bluetooth)
- Praca kolektorów polega wysyłaniu zapytań do źródła danych (API), odbieraniu danych i parsowaniu ich do danych możliwych do zapisania i użycia w programie
- Każdy kolektor musi mieć swój ekran w menu Ustawienia, gdyż może wymagać ustawienia swoich własnych parametrów takich jak Login, Hasło, interwały czasowe, adresy API.

10. Widget
- Program musi umożliwiać wyświetlenie prostego widgetu zawierającego:
    - Uproszczony wykres danych o glukozie z ostatniej godziny
    - Linie zakresu dolnego i górnego
    - Najnowszą wartość glukozy, przekreśloną w przypadku przekroczenia czasu timeout
    - Czas i wartość zmiany od ostatniego pomiaru zachowujące się w sposób analogiczny jak te same wartości na ekranie głównym programu









Architektura:
Dokument opisuje architekturę aplikacji mobilnej na system Android napisanej w języku Java, zgodnie z wymaganiami zawartymi w pliku Wymagania.txt. Zastosowano nowoczesne podejście Clean Architecture oraz wzorzec MVVM, co zapewnia modularność, testowalność i skalowalność aplikacji.

1. Architektura aplikacji
   Zalecana architektura to Clean Architecture z podziałem na trzy główne warstwy:
- Presentation Layer: UI, ViewModel, LiveData/StateFlow
- Domain Layer: UseCase’y, interfejsy repozytoriów
- Data Layer: Repozytoria, źródła danych (API, lokalna baza danych (Room), kolektory)

2. Wzorzec MVVM
   Model-View-ViewModel zapewnia separację logiki biznesowej od interfejsu użytkownika. ViewModel komunikuje się z warstwą domenową i udostępnia dane UI poprzez LiveData lub StateFlow.

3. Mechanizmy i biblioteki
   3.1 Wykresy:
- MPAndroidChart – do wykresów liniowych, słupkowych, spline, kołowych
- CustomView – dla bardziej zaawansowanych interakcji (np. miniatura wykresu, gesty, tooltipy)

3.2 Baza danych:
- Room – lokalna baza danych z obsługą SQLite
- DataStore – do przechowywania ustawień konfiguracyjnych

3.3 Sieć i kolektory:
- Retrofit + OkHttp – komunikacja z API
- WorkManager – do cyklicznego uruchamiania kolektorów (np. co 5 minut)
- Executors – do obsługi asynchronicznej

3.4 Powiadomienia i alarmy:
- AlarmManager + BroadcastReceiver – do aktywacji alarmów
- NotificationManager – do wyświetlania powiadomień
- ForegroundService – dla krytycznych funkcji (np. alarmy ignorujące tryb „nie przeszkadzać”)

3.5 Widget:
- AppWidgetProvider – do tworzenia widgetu z uproszczonym wykresem

3.6 Testowanie:
- JUnit + Mockito – testy jednostkowe
- Espresso – testy UI

4. Wzorce projektowe
- Repository Pattern – separacja źródeł danych
- Observer Pattern – LiveData / Flow do obserwacji danych
- Factory Pattern – do tworzenia obiektów kolektorów
- Strategy Pattern – do obliczeń (np. IoB, aktywność insuliny)
- Command Pattern – do obsługi dodawania danych ręcznie

5. Narzędzia developerskie
- Android Studio
- Firebase Crashlytics – monitorowanie błędów
- LeakCanary – wykrywanie wycieków pamięci
- Proguard / R8 – optymalizacja i obfuskacja kodu

6. Bezpieczeństwo
- EncryptedSharedPreferences / SQLCipher – szyfrowanie danych lokalnych
- HTTPS + certyfikaty – bezpieczna komunikacja z API

7. Backup i import/export
- JSON/XML serializacja – eksport ustawień
- Zxing / ML Kit do kodów QR – generowanie i skanowanie kodów QR

8. Struktura katalogów
   •	com.kukuchta.diabetool
   •	├── data
   •	│   ├── api
   •	│   ├── db
   •	│   ├── repository
   •	├── domain
   •	│   ├── model
   •	│   ├── usecase
   •	├── presentation
   •	│   ├── main
   •	│   ├── history
   •	│   ├── statistics
   •	│   ├── alarms
   •	│   ├── settings
   •	│   ├── backup
   •	│   ├── status
   •	│   ├── widget
   •	├── collectors
   •	│   ├── base
   •	│   ├── plugins
   •	├── navigation
   •	├── utils









Pluginowy Model Kolektorów – Dokumentacja Techniczna

1. Wprowadzenie
   W odpowiedzi na wymagania zawarte w pliku 'Wymagania.txt', proponujemy zastosowanie pluginowego modelu kolektorów. Każdy kolektor może mieć inne źródło danych (API, Bluetooth, pliki lokalne), własną konfigurację oraz sposób działania. Podejście pluginowe zapewnia modularność, skalowalność i łatwość rozbudowy aplikacji.

2. Struktura katalogów
   Proponowana struktura katalogów dla kolektorów:
   com.example.glucosemonitorapp.collectors
   ├── base
   │   ├── Collector.java (interfejs)
   │   ├── CollectorConfig.java
   ├── plugins
   │   ├── ApiCollector.java
   │   ├── BluetoothCollector.java
   │   ├── FileCollector.java

3. Wzorce projektowe
   W modelu pluginowym kolektorów wykorzystujemy następujące wzorce projektowe:
- Plugin – każdy kolektor to niezależny moduł
- Factory – CollectorFactory tworzy instancje kolektorów na podstawie konfiguracji
- Strategy – każdy kolektor ma własną strategię pobierania i parsowania danych

4. Relacja z data/api
   Moduł data/api zawiera ogólne definicje API (np. GlucoseApiService, PumpStatusApi). Kolektory korzystają z data/api tylko jeśli wymagają komunikacji sieciowej. BluetoothCollector i FileCollector nie potrzebują dostępu do data/api.

5. Korzyści podejścia pluginowego
- Modularność – łatwo dodawać nowe typy kolektorów
- Testowalność – każdy kolektor można testować niezależnie
- Skalowalność – gotowe na przyszłe rozszerzenia (Bluetooth, NFC, pliki lokalne)
- Konfigurowalność – każdy kolektor ma własne parametry konfiguracyjne

6. Konfiguracja kolektorów
   Zgodnie z wymaganiami, każdy kolektor musi mieć swój ekran w menu Ustawienia. Konfiguracja obejmuje takie parametry jak login, hasło, interwał czasowy, adres API, itp. Proponujemy utworzenie CollectorSettingsFragment oraz CollectorConfigManager do zarządzania konfiguracją.








# ✅ Szczegółowa Checklista Implementacji Aplikacji Mobilnej (Android, Java)

## 🔷 Etap 1: Analiza i planowanie
- [X] Przejrzenie dokumentu `Wymagania.txt`
- [X] Podział funkcjonalności na moduły (Main, History, Statistics, Alarms, Settings, Backup, Widget, Collectors)
- [X] Zdefiniowanie modeli danych (GlucoseReading, Meal, Bolus, Notification, BasalInsulin, ActiveInsulin, AutoCorrection, AutoBasal, Measurement)

## 🏗️ Etap 2: Przygotowanie środowiska
- [X] Utworzenie projektu w Android Studio (Java)
- [X] Konfiguracja `build.gradle` (MPAndroidChart, Room, Retrofit, WorkManager, Lifecycle, itp.)
- [X] Utworzenie struktury katalogów zgodnej z Clean Architecture

## 🧱 Etap 3: Warstwa domenowa (Domain Layer)
- [X] Utworzenie modeli domenowych
- [X] Utworzenie interfejsów repozytoriów
- [X] Implementacja UseCase’ów (np. GetGlucoseDataUseCase, CalculateIoBUseCase)

## 🗂️ Etap 4: Warstwa danych (Data Layer)
- [X] Implementacja `data/db` (Room + DAO)
- [ ] Implementacja `data/api` (Retrofit + DTO)
- [ ] Implementacja `data/repository` (łączenie API i DB)
- [ ] Obsługa DataStore do konfiguracji

## 🔌 Etap 5: Pluginowy model kolektorów
- [ ] Utworzenie interfejsu `Collector`
- [ ] Implementacja `ApiCollector`, `BluetoothCollector`, `FileCollector`
- [ ] Utworzenie `CollectorFactory` i `CollectorRegistry`
- [ ] Obsługa konfiguracji kolektorów (`CollectorConfig`)
- [ ] Integracja z WorkManager (cykliczne uruchamianie co 5 minut)
- [ ] Obsługa wielu kolektorów jednocześnie

## 🎨 Etap 6: Warstwa prezentacji (Presentation Layer)
- [ ] Implementacja `MainActivity` i `MainViewModel`
- [ ] Implementacja `HistoryFragment`, `StatisticsFragment`, `AlarmsFragment`, `SettingsFragment`, `BackupFragment`, `StatusFragment`
- [ ] Obsługa LiveData / StateFlow
- [ ] Obsługa konfiguracji kolorów, tooltipów, gestów

## 📊 Etap 7: Wykres główny i miniatura
- [ ] Implementacja wykresu głównego (MPAndroidChart)
- [ ] Obsługa danych glukozy, posiłków, bolusów, powiadomień, bazy, IoB, aktywności insuliny, autokorekt, autobazy, pomiarów
- [ ] Implementacja miniatury zsynchronizowanej z wykresem głównym
- [ ] Obsługa kursora, tooltipów, skalowania, kolorów

## 🔁 Etap 8: Synchronizacja i dane bieżące
- [ ] Obliczanie danych bieżących (glukoza, trend, czas odczytu, IoB, DDI, węglowodany, baterie, połączenia)
- [ ] Obsługa timeoutów i kolorów
- [ ] Wyświetlanie danych nad wykresem

## ➕ Etap 9: Dodawanie danych ręcznie
- [ ] Implementacja przycisku dodawania danych
- [ ] Obsługa formularzy dla: posiłku, bolusa, pomiaru, notatki, zmiany wkłucia, zmiany sensora

## 📈 Etap 10: Historia i statystyki
- [ ] Implementacja ekranu historii z wykresem i wyborem daty
- [ ] Implementacja statystyk z wyborem zakresu i wykresem kołowym

## 🚨 Etap 11: Alarmy
- [ ] Implementacja listy alarmów
- [ ] Obsługa typów alarmów, warunków, interwałów, dźwięków
- [ ] Obsługa aktywacji alarmów (ForegroundService, NotificationManager)
- [ ] Obsługa edycji, usuwania, duplikowania alarmów

## 🧰 Etap 12: Ustawienia i konfiguracja
- [ ] Implementacja ekranu ustawień
- [ ] Obsługa dynamicznej aktualizacji UI
- [ ] Obsługa konfiguracji kolektorów

## 💾 Etap 13: Backup i import/export
- [ ] Eksport/import danych historycznych
- [ ] Eksport/import ustawień (JSON/XML)
- [ ] Obsługa kodów QR (Zxing / ML Kit)

## 📱 Etap 14: Widget
- [ ] Implementacja uproszczonego widgetu z wykresem i danymi

## 🧪 Etap 15: Testowanie
- [ ] Testy jednostkowe (JUnit, Mockito)
- [ ] Testy UI (Espresso)
- [ ] Testy integracyjne kolektorów i alarmów

## 🚀 Etap 16: Publikacja i optymalizacja
- [ ] Konfiguracja Proguard / R8
- [ ] Integracja Crashlytics, LeakCanary
- [ ] Przygotowanie do publikacji w Google Play
