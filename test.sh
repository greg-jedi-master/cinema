path=http://localhost:8080/api

echo ">>> Wylistuj wszystkie seanse: [GET][/api/screenings]"

curl $path/screenings | json_pp

echo ">>> Wylistuj wszystkie seanse zaczynające się pomiędzy wskazanym czasem a północą: [GET][/api/screenings?time=2022-06-06T18:00:00]"

curl $path/screenings?time=2022-06-06T18:00:00 | json_pp

echo ">>> Pobierz informacje dotyczące pokoju i wolnych miejsc dla wskazanego seansu: [GET][/api/screenings/1]"

curl $path/screenings/1 | json_pp

echo ">>> Jeśli seans o podanym id nie istnieje: [GET][api/screenings/88]"

curl $path/screenings/88 | json_pp

echo ">>> Zarezerwuj dwa miejsca: [POST][api/screenings/1/reservations]"

curl -X POST $path/screenings/1/reservations -H "Content-Type: application/json" -d '{
		"firstName": "Mirosław",
		"lastName": "Zbrojewicz",
		"seats":
		[
			{
				"seatNumber": "1",
				"ticketType": "2"
			},
			{
				"seatNumber": "2",
				"ticketType": "0"
			}
		]
	}' | json_pp

echo ">>> Jeżeli rezerwacja jest robiona za póżno (do seansu zostało mniej niż 15 min): [POST][api/screenings/7/reservations]"

curl -X POST $path/screenings/7/reservations -H "Content-Type: application/json" -d '{
		"firstName": "Mirosław",
		"lastName": "Zbrojewicz",
		"seats":
		[
			{
				"seatNumber": "1",
				"ticketType": "2"
			},
			{
				"seatNumber": "2",
				"ticketType": "0"
			}
		]
	}' | json_pp

echo ">>> Jeżeli miejsce nie może zostać zarezerwowane (spowodowałoby jedno wolne miesce pomiędzy zajętymi): [POST][api/screenings/1/reservations]"

curl -X POST $path/screenings/1/reservations -H "Content-Type: application/json" -d '{
		"firstName": "Michał",
		"lastName": "Milowicz",
		"seats":
		[
			{
				"seatNumber": "4",
				"ticketType": "2"
			}
		]
	}' | json_pp

echo ">>> Jeżeli niepoprawne dane zostaną wysłane w zapytaniu (zbyt krótkie imię): [POST][api/screenings/1/reservations]"

curl -X POST $path/screenings/1/reservations -H "Content-Type: application/json" -d '{
		"firstName": "Mi",
		"lastName": "Milowicz",
		"seats":
		[
			{
				"seatNumber": "4",
				"ticketType": "2"
			}
		]
	}' | json_pp		