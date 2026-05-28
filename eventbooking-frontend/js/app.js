const BASE_URL =
    "http://localhost:8080";

// TOKEN
function token() {

    return localStorage.getItem(
        "token"
    );
}

<<<<<<< HEAD
// ROLE
function role() {

    return localStorage.getItem(
        "role"
    );
}

=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
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
<<<<<<< HEAD
            data.username
        );

        localStorage.setItem(
            "role",
            data.role
=======
            username
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
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
<<<<<<< HEAD

    if (
        role() === "ADMIN"
    ) {

        const adminButton =
            document.getElementById(
                "adminButton"
            );

        if (adminButton) {

            adminButton.style.display =
                "block";
        }
    }
=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
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

<<<<<<< HEAD
    document.getElementById(
        "adminSection"
    ).style.display = "none";

=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
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

<<<<<<< HEAD
    document.getElementById(
        "adminSection"
    ).style.display = "none";

=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
    loadBookings();
}

//
<<<<<<< HEAD
// PANEL ADMIN
//
function showAdminPanel() {

    document.getElementById(
        "adminSection"
    ).style.display = "block";

    document.getElementById(
        "eventsSection"
    ).style.display = "none";

    document.getElementById(
        "bookingsSection"
    ).style.display = "none";

    loadAdminEvents();
}

//
// CARGAR EVENTOS ADMIN
//
//
// CARGAR EVENTOS ADMIN
//
async function loadAdminEvents() {

    try {

        const res =
            await fetch(
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

        events.forEach((e) => {

            html += `
                <div class="card">

                    <h3>
                        ${e.title}
                    </h3>

                    <p>
                        📍 ${e.venue}
                    </p>

                    <p>
                        📅 ${e.event_date}
                    </p>

                    <p>
                        👥 ${e.capacity}
                    </p>

                    <p>
                        💲 ${e.price_per_ticket}
                    </p>

                    <div class="admin-buttons">

                        <button
                            onclick="editEvent(${e.id_event})">

                            Editar

                        </button>

                        <button
                            onclick="deleteEvent(${e.id_event})">

                            Eliminar

                        </button>

                    </div>

                </div>
            `;
        });

        document.getElementById(
            "adminEvents"
        ).innerHTML = html;

    } catch (error) {

        console.log(error);

        showMessage(
            "Error cargando eventos admin"
        );
    }
}

//
// CARGAR EVENTOS
//

=======
// CARGAR EVENTOS
//
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
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

<<<<<<< HEAD
        // VALIDAR RESPUESTA
        if (!res.ok) {

            if (res.status === 403) {

                showMessage(
                    "No autorizado"
                );

                return;
            }

            showMessage(
                "Error cargando eventos"
            );

            return;
        }

=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
        const events =
            await res.json();

        let html = "";

<<<<<<< HEAD
        events.forEach((e) => {
=======
        events.forEach(e => {
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49

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

<<<<<<< HEAD
        const activeBookings =
            bookings.filter(
                b => b.status !== "CANCELLED"
            );

        if (
            activeBookings.length === 0
        ) {

            html =
                `
                <p>
                    No tienes reservas activas
                </p>
                `;
        }

        activeBookings.forEach((b) => {
=======
        bookings.forEach(b => {
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49

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
<<<<<<< HEAD
                        onclick="cancelBooking(${b.id_booking})">
=======
                        onclick="cancelBooking(
                            ${b.id_booking}
                        )">
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49

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
<<<<<<< HEAD
            "Error cargando reservas"
=======
            "No se pudieron cargar reservas"
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
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

<<<<<<< HEAD
        loadBookings();

=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
    } catch (error) {

        console.log(error);
    }
}

//
<<<<<<< HEAD
// CREAR EVENTO
//
//
// CREAR O ACTUALIZAR EVENTO
//
async function saveEvent() {

    const title =
        document.getElementById(
            "eventTitle"
        ).value;

    const description =
        document.getElementById(
            "eventDescription"
        ).value;

    const date =
        document.getElementById(
            "eventDate"
        ).value;

    const venue =
        document.getElementById(
            "eventVenue"
        ).value;

    const capacity =
        document.getElementById(
            "eventCapacity"
        ).value;

    const price =
        document.getElementById(
            "eventPrice"
        ).value;

    if (
        title === "" ||
        description === "" ||
        date === "" ||
        venue === "" ||
        capacity === "" ||
        price === ""
    ) {

        showMessage(
            "Completa todos los campos"
        );

        return;
    }

    // VALIDAR FECHA
    const selectedDate =
        new Date(date);

    const now =
        new Date();

    if (selectedDate < now) {

        showMessage(
            "No puedes usar fechas pasadas"
        );

        return;
    }

    const eventData = {

        title: title,

        description: description,

        event_date: date,

        venue: venue,

        capacity:
            parseInt(capacity),

        price_per_ticket:
            parseFloat(price)
    };

    // CREAR O EDITAR
    let url =
        `${BASE_URL}/api/events`;

    let method =
        "POST";

    if (editingEventId) {

        url =
            `${BASE_URL}/api/events/${editingEventId}`;

        method =
            "PUT";
    }

    try {

        const res =
            await fetch(
                url,
                {
                    method: method,

                    headers: {
                        "Content-Type":
                            "application/json",

                        Authorization:
                            "Bearer " + token()
                    },

                    body: JSON.stringify(
                        eventData
                    )
                }
            );

        if (res.ok) {

            showMessage(
                editingEventId
                    ? "Evento actualizado"
                    : "Evento creado"
            );

            // LIMPIAR FORM
            document.getElementById(
                "eventTitle"
            ).value = "";

            document.getElementById(
                "eventDescription"
            ).value = "";

            document.getElementById(
                "eventDate"
            ).value = "";

            document.getElementById(
                "eventVenue"
            ).value = "";

            document.getElementById(
                "eventCapacity"
            ).value = "";

            document.getElementById(
                "eventPrice"
            ).value = "";

            editingEventId = null;

            loadAdminEvents();

        } else {

            showMessage(
                "Error guardando evento"
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
// EDITAR EVENTO
//
//
// EDITAR EVENTO
//
let editingEventId = null;

async function editEvent(id) {

    try {

        const res =
            await fetch(
                `${BASE_URL}/api/events/${id}`,
                {
                    headers: {
                        Authorization:
                            "Bearer " + token()
                    }
                }
            );

        const e =
            await res.json();

        // LLENAR FORMULARIO
        document.getElementById(
            "eventTitle"
        ).value = e.title;

        document.getElementById(
            "eventDescription"
        ).value = e.description;

        document.getElementById(
            "eventDate"
        ).value = e.event_date;

        document.getElementById(
            "eventVenue"
        ).value = e.venue;

        document.getElementById(
            "eventCapacity"
        ).value = e.capacity;

        document.getElementById(
            "eventPrice"
        ).value = e.price_per_ticket;

        editingEventId = id;

        showMessage(
            "Editando evento..."
        );

    } catch (error) {

        console.log(error);

        showMessage(
            "Error cargando evento"
        );
    }
}
//
// ELIMINAR EVENTO
//
async function deleteEvent(id) {

    const confirmDelete =
        confirm(
            "¿Eliminar evento?"
        );

    if (!confirmDelete) {

        return;
    }

    try {

        const res =
            await fetch(
                `${BASE_URL}/api/events/${id}`,
                {
                    method: "DELETE",

                    headers: {
                        Authorization:
                            "Bearer " + token()
                    }
                }
            );

        if (res.ok) {

            showMessage(
                "Evento eliminado"
            );

            loadAdminEvents();

        } else {

            showMessage(
                "Error eliminando"
            );
        }

    } catch (error) {

        console.log(error);
    }
}


//
=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
// LOGOUT
//
function logout() {

    localStorage.removeItem(
        "token"
    );

    localStorage.removeItem(
        "username"
    );

<<<<<<< HEAD
    localStorage.removeItem(
        "role"
    );

=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
    window.location.href =
        "index.html";
}