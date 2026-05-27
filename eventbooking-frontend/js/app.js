const BASE_URL =
    "http://localhost:8080";

// TOKEN
function token() {

    return localStorage.getItem(
        "token"
    );
}

// MENSAJES
function showMessage(msg) {

    const message =
        document.getElementById(
            "message"
        );

    if (message) {

        message.innerText = msg;
    }
}

//
// LOGIN
//
async function login() {

    const username =
        document.getElementById(
            "loginUsername"
        ).value;

    const password =
        document.getElementById(
            "loginPassword"
        ).value;

    if (
        username === "" ||
        password === ""
    ) {

        showMessage(
            "Completa todos los campos"
        );

        return;
    }

    try {

        const res = await fetch(
            `${BASE_URL}/api/auth/login`,
            {
                method: "POST",

                headers: {
                    "Content-Type":
                        "application/json"
                },

                body: JSON.stringify({
                    username: username,
                    password: password
                })
            }
        );

        if (!res.ok) {

            showMessage(
                "Credenciales incorrectas"
            );

            return;
        }

        const data =
            await res.json();

        localStorage.setItem(
            "token",
            data.token
        );

        localStorage.setItem(
            "username",
            username
        );

        window.location.href =
            "dashboard.html";

    } catch (error) {

        console.log(error);

        showMessage(
            "Error al iniciar sesión"
        );
    }
}

//
// REGISTRO
//
async function registerUser() {

    const username =
        document.getElementById(
            "regUsername"
        ).value;

    const firstname =
        document.getElementById(
            "regFirstname"
        ).value;

    const lastname =
        document.getElementById(
            "regLastname"
        ).value;

    const age =
        document.getElementById(
            "regAge"
        ).value;

    const password =
        document.getElementById(
            "regPassword"
        ).value;

    if (
        username === "" ||
        firstname === "" ||
        lastname === "" ||
        age === "" ||
        password === ""
    ) {

        showMessage(
            "Completa todos los campos"
        );

        return;
    }

    try {

        const res = await fetch(
            `${BASE_URL}/api/auth/register`,
            {
                method: "POST",

                headers: {
                    "Content-Type":
                        "application/json"
                },

                body: JSON.stringify({
                    username: username,
                    firstname: firstname,
                    lastname: lastname,
                    age: parseInt(age),
                    password: password
                })
            }
        );

        if (res.ok) {

            showMessage(
                "Usuario registrado"
            );

            setTimeout(() => {

                window.location.href =
                    "index.html";

            }, 1500);

        } else {

            showMessage(
                "Error al registrar"
            );
        }

    } catch (error) {

        console.log(error);

        showMessage(
            "Error del servidor"
        );
    }
}

//
// BIENVENIDA
//
window.onload = () => {

    const welcome =
        document.getElementById(
            "welcome"
        );

    if (welcome) {

        const username =
            localStorage.getItem(
                "username"
            );

        welcome.innerText =
            "Bienvenido " +
            username +
            " 👋";
    }
};

//
// MOSTRAR EVENTOS
//
function showEvents() {

    document.getElementById(
        "eventsSection"
    ).style.display = "block";

    document.getElementById(
        "bookingsSection"
    ).style.display = "none";

    loadEvents();
}

//
// MOSTRAR RESERVAS
//
function showBookings() {

    document.getElementById(
        "bookingsSection"
    ).style.display = "block";

    document.getElementById(
        "eventsSection"
    ).style.display = "none";

    loadBookings();
}

//
// CARGAR EVENTOS
//
async function loadEvents() {

    try {

        const res = await fetch(
            `${BASE_URL}/api/events`,
            {
                headers: {
                    Authorization:
                        "Bearer " + token()
                }
            }
        );

        const events =
            await res.json();

        let html = "";

        events.forEach(e => {

            html += `
                <div class="card">

                    <h3>
                        ${e.title}
                    </h3>

                    <p>
                        📍 ${e.venue}
                    </p>

                    <p>
                        💲 ${e.price_per_ticket}
                    </p>

                    <p>
                        👥 ${e.capacity} cupos
                    </p>

                    <button
                        onclick="book(${e.id_event})">

                        Reservar

                    </button>

                </div>
            `;
        });

        document.getElementById(
            "events"
        ).innerHTML = html;

    } catch (error) {

        console.log(error);

        showMessage(
            "No se pudieron cargar eventos"
        );
    }
}

//
// RESERVAR
//
async function book(idEvent) {

    const quantity =
        prompt(
            "Cantidad:"
        );

    const userId =
        prompt(
            "Tu userId:"
        );

    try {

        const res = await fetch(
            `${BASE_URL}/api/bookings`,
            {
                method: "POST",

                headers: {
                    "Content-Type":
                        "application/json",

                    Authorization:
                        "Bearer " + token()
                },

                body: JSON.stringify({
                    eventId: idEvent,
                    userId: parseInt(userId),
                    quantity: parseInt(quantity)
                })
            }
        );

        if (res.ok) {

            showMessage(
                "Reserva creada"
            );

        } else {

            showMessage(
                "No hay cupos disponibles"
            );
        }

    } catch (error) {

        console.log(error);
    }
}

//
// CARGAR RESERVAS
//
async function loadBookings() {

    try {

        const res = await fetch(
            `${BASE_URL}/api/bookings/my`,
            {
                headers: {
                    Authorization:
                        "Bearer " + token()
                }
            }
        );

        const bookings =
            await res.json();

        let html = "";

        bookings.forEach(b => {

            html += `
                <div class="card">

                    <h3>
                        ${b.event.title}
                    </h3>

                    <p>
                        🎟 Cantidad:
                        ${b.quantity}
                    </p>

                    <p>
                        💲 Total:
                        ${b.total_amount}
                    </p>

                    <p>
                        📌 Estado:
                        ${b.status}
                    </p>

                    <button
                        onclick="cancelBooking(
                            ${b.id_booking}
                        )">

                        Cancelar

                    </button>

                </div>
            `;
        });

        document.getElementById(
            "bookings"
        ).innerHTML = html;

    } catch (error) {

        console.log(error);

        showMessage(
            "No se pudieron cargar reservas"
        );
    }
}

//
// CANCELAR
//
async function cancelBooking(id) {

    try {

        await fetch(
            `${BASE_URL}/api/bookings/${id}`,
            {
                method: "DELETE",

                headers: {
                    Authorization:
                        "Bearer " + token()
                }
            }
        );

        showMessage(
            "Reserva cancelada"
        );

    } catch (error) {

        console.log(error);
    }
}

//
// LOGOUT
//
function logout() {

    localStorage.removeItem(
        "token"
    );

    localStorage.removeItem(
        "username"
    );

    window.location.href =
        "index.html";
}