package Interfaz;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import Mundo.Peaje;
import Mundo.Plan;
import Mundo.PlanBasico;
import Mundo.PlanPlus;
import Mundo.PlanPremium;
import Mundo.Usuario;
import Mundo.Vehiculo;

public class Main {

	// Método validación de opciones del menu solo numeros

	public static int solicitarNumero(Scanner sc) {
		int numero;

		while (true) {

			if (sc.hasNextInt()) {
				numero = sc.nextInt();
				return numero;
			} else {
				System.out.println("Error: solo puede ingresar números.");
				System.out.println("Seleccione una opción: ");
				sc.next();
			}
		}
	}

	// Método validación para valor de recarga solo valores enteros

	public static double ValidarNumero(Scanner sc) {
		while (true) {
			if (sc.hasNextDouble()) {
				return sc.nextDouble();
			}

			System.out.println("Error: solo puede ingresar números.");
			sc.next();
		}
	}

	// Clase Main Inicio Programa

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Se crean objetos de vehículos
		Vehiculo v1 = new Vehiculo("ABC123", 1);
		Vehiculo v2 = new Vehiculo("DEF456", 3);
		Vehiculo v3 = new Vehiculo("GHI789", 5);
		Vehiculo v4 = new Vehiculo("REO809", 7);

		// Se crean objetos de planes
		Plan p1 = new PlanBasico(0.00); // 00%
		Plan p2 = new PlanPlus(0.10); // 10%
		Plan p3 = new PlanPremium(0.20); // 20%

		// Se crean objetos de usuarios
		Usuario u1 = new Usuario("U001", "Carlos", 0, v1, p1);
		Usuario u2 = new Usuario("U002", "Hirasska", 600000, v2, p2);
		Usuario u3 = new Usuario("U003", "Sofia", 700000, v3, p3);
		Usuario u4 = new Usuario("U004", "Celso", 1200000, v4, p3);

		// Lista de usuarios registrados

		ArrayList<Usuario> usuarios = new ArrayList<>();

		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);
		usuarios.add(u4);

		// Lista cargada de peajes

		Peaje[] peajes = {
				new Peaje("Alto Pino",
						new Double[] { 14800.00, 22900.00, 18400.00, 29100.00, 42500.00, 68300.00, 86200.00 }),
				new Peaje("Los Patios",
						new Double[] { 14800.00, 23100.00, 35700.00, 52300.00, 71700.00, 72100.00, null }),
				new Peaje("Andes",
						new Double[] { 15200.00, 26400.00, 17500.00, 37100.00, 54500.00, 68900.00, 75900.00 }),
				new Peaje("Gualanday", new Double[] { 15300.00, 18000.00, 42400.00, 57000.00, 62500.00, null, null }),
				new Peaje("Siberia",
						new Double[] { 15300.00, 21800.00, 18300.00, 24400.00, 42600.00, 57000.00, 62700.00 }),
				new Peaje("Chinauta", new Double[] { 16100.00, 17900.00, 38000.00, 61700.00, 70700.00, null, null }),
				new Peaje("Chusaca", new Double[] { 16100.00, 17900.00, 38000.00, 61700.00, 70700.00, null, null }),
				new Peaje("Chicoral",
						new Double[] { 16600.00, 18300.00, 16600.00, 21500.00, 43700.00, 58000.00, 64000.00 }),
				new Peaje("Flandes",
						new Double[] { 18900.00, 23400.00, 28900.00, 36600.00, 55800.00, 70000.00, 81000.00 }),
				new Peaje("Pamplonita",
						new Double[] { 21800.00, 27100.00, 32200.00, 45800.00, 64700.00, 81500.00, 94400.00 })
		};

		//Se crea una pila para guardar registros de pasos exitosos de peajes

		Stack<String> historialPeajes = new Stack<>();

		/*
		*Se inicializa en este programa consecutivo en 5, ya que tenemos 4 usuarios
		*por defecto registrados y ahi empieza el contador unico
		*/

		int consecutivoUsuario = 5;

		// Inicializacion de opciones de programa

		int opcion;

		do {
			System.out.println("\n=================================");
			System.out.println(" SISTEMA DE PEAJES");
			System.out.println("=================================");
			System.out.println("1. Ver usuarios");
			System.out.println("2. Pasar por un peaje");
			System.out.println("3. Recargar saldo");
			System.out.println("4. Consultar saldo");
			System.out.println("5. Crear Usuario");
			System.out.println("6. Ver historial de peajes");
			System.out.println("7. Eliminar Usuario");
			System.out.println("8. Actualizar Plan");
			System.out.println("9. Salir");

			System.out.print("Seleccione una opción: ");

			opcion = solicitarNumero(sc);

			switch (opcion) {
				case 1:

					System.out.println("\n=== LISTA DE USUARIOS ===");

					for (int i = 0; i < usuarios.size(); i++) {
						System.out.println((i + 1) + ". "
								+ usuarios.get(i));
					}

					break;

				case 2:

					System.out.println("\n=== PASAR POR UN PEAJE ===");

					System.out.println("\nUsuarios disponibles:");

					for (int i = 0; i < usuarios.size(); i++) {
						System.out.println((i + 1) + ". " +
								usuarios.get(i).getNombre());
					}

					int indiceUsuario = solicitarNumero(sc) - 1;

					if (indiceUsuario < 0 || indiceUsuario >= usuarios.size()) {
						System.out.println("Usuario no válido.");
						break;
					}

					Usuario usuario = usuarios.get(indiceUsuario);

					System.out.println("\nPeajes disponibles:");

					for (int i = 0; i < peajes.length; i++) {
						System.out.println((i + 1) + ". " +
								peajes[i].getNombre());
					}

					int indicePeaje = solicitarNumero(sc) - 1;

					if (indicePeaje < 0 || indicePeaje >= peajes.length) {
						System.out.println("Peaje no válido.");
						break;
					}

					Peaje peajeSeleccionado = peajes[indicePeaje];

					int categoria = usuario.getVehiculo().obtenerCategoria();

					double valorPeaje = peajeSeleccionado.getTarifas()[categoria - 1];

					double tarifaFinal = usuario.getPlan().calcularTarifa(valorPeaje);

					System.out.println("\n===== RESUMEN DEL COBRO =====");
					System.out.println("Usuario: " + usuario.getNombre());
					System.out.println("Peaje: " + peajeSeleccionado.getNombre());
					System.out.println("Categoría vehículo: " + categoria);
					System.out.println("Tarifa base: $" + valorPeaje);
					System.out.println("Tarifa con descuento: $" + tarifaFinal);
					System.out.println("Saldo: $" + usuario.getSaldo());
					boolean pagoExitoso = usuario.descontarSaldo(tarifaFinal);

					if (pagoExitoso) {
						System.out.println("Saldo restante: $" +
								usuario.getSaldo());

						historialPeajes.push(
								usuario.getNombre()
										+ " pasó por "
										+ peajeSeleccionado.getNombre()
										+ " y pagó $"
										+ tarifaFinal);
					} else {
						System.out.println("\nSaldo insuficiente.");
						System.out.println("¿Desea recargar saldo?");
						System.out.println("1. Sí");
						System.out.println("2. No");

						int respuesta;

						while (true) {
							respuesta = solicitarNumero(sc);

							if (respuesta == 1 || respuesta == 2) {
								break;
							}

							System.out.println("Error: solo puede seleccionar 1 o 2.");
						}

						if (respuesta == 1) {
							while (true) {
								try {
									System.out.print("Valor a recargar: ");

									if (!sc.hasNextDouble()) {
										throw new IllegalArgumentException(
												"Debe ingresar un valor numérico.");
									}

									double recarga = sc.nextDouble();

									usuario.recargarSaldo(recarga);

									System.out.println("Recarga exitosa.");
									System.out.println("Saldo actual: $"
											+ usuario.getSaldo());

									break;
								} catch (IllegalArgumentException e) {
									System.out.println(e.getMessage());
									sc.nextLine();
								}
							}

							System.out.println("\n¿Desea confirmar el paso por el peaje?");
							System.out.println("1. Sí");
							System.out.println("2. No");

							int confirmar = solicitarNumero(sc);

							if (confirmar == 1) {
								if (usuario.descontarSaldo(tarifaFinal)) {
									System.out.println("Peaje pagado correctamente.");
									System.out.println("Saldo restante: $"
											+ usuario.getSaldo());

									historialPeajes.push(
											usuario.getNombre()
													+ " pasó por "
													+ peajeSeleccionado.getNombre()
													+ " y pagó $"
													+ tarifaFinal);
								} else {
									System.out.println(
											"La recarga realizada aún no es suficiente para cubrir el peaje.");
								}
							}
						}
					}

					break;

				case 3:

					System.out.println("\n¿A qué usuario desea recargar?");

					for (int i = 0; i < usuarios.size(); i++) {
						System.out.println((i + 1) + ". "
								+ usuarios.get(i).getNombre());
					}

					int indiceUsuarioRecarga = solicitarNumero(sc) - 1;

					if (indiceUsuarioRecarga >= 0 &&
							indiceUsuarioRecarga < usuarios.size()) {
						try {
							System.out.print("Valor a recargar: ");
							double recarga = ValidarNumero(sc);

							usuarios.get(indiceUsuarioRecarga)
									.recargarSaldo(recarga);

							System.out.println("Recarga exitosa.");
							System.out.println("Nuevo saldo: $"
									+ usuarios.get(indiceUsuarioRecarga).getSaldo());
						} catch (IllegalArgumentException e) {
							System.out.println("Error: " + e.getMessage());
						}

					} else {
						System.out.println("Usuario no válido.");
					}

					break;

				case 4:

					System.out.println("\n=== SALDOS ACTUALES ===");

					for (Usuario u : usuarios) {
						System.out.println(
								"Usuario: " + u.getNombre()
										+ " | Saldo: $" + u.getSaldo());
					}

					break;

				case 5:

					System.out.println("\n=== CREAR USUARIO ===");

					String userId = String.format("U%03d", consecutivoUsuario++);

					String nombre;

					while (true) {
						System.out.print("Nombre: ");
						nombre = sc.next();

						if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
							break;
						}

						System.out.println("Error: el nombre solo puede contener letras.");
					}

					double saldo = 0;

					String placa;

					while (true) {
						System.out.print("Placa: ");
						placa = sc.next().toUpperCase();

						boolean existe = false;

						for (Usuario u : usuarios) {
							if (u.getVehiculo().obtenerPlaca().equalsIgnoreCase(placa)) {
								existe = true;
								break;
							}
						}

						if (existe) {
							System.out.println("Error: la placa ya está registrada.");
						} else {
							break;
						}
					}

					System.out.println("\nSeleccione la categoría del vehículo:");
					System.out.println("1. Categoría I  - Automóviles, camperos, camionetas");
					System.out.println("2. Categoría II - Buses, busetas, microbuses");
					System.out.println("3. Categoría III - Camiones de 2 ejes");
					System.out.println("4. Categoría IV - Camiones de 2 ejes con doble llanta");
					System.out.println("5. Categoría V - Camiones de 3 a 5 ejes");
					System.out.println("6. Categoría VI - Camiones de 6 ejes");
					System.out.println("7. Categoría VII - Camiones de 7 ejes o más");

					int categoriaC = solicitarNumero(sc);

					while (categoriaC < 1 || categoriaC > 7) {
						System.out.println("Error: la categoría debe estar entre 1 y 7.");
						categoriaC = solicitarNumero(sc);
					}

					Vehiculo nuevoVehiculo = new Vehiculo(placa, categoriaC);

					System.out.println("\nSeleccione plan:");
					System.out.println("1. Básico");
					System.out.println("2. Plus");
					System.out.println("3. Premium");

					int planSeleccionado = solicitarNumero(sc);

					Plan plan;

					switch (planSeleccionado) {
						case 1:
							plan = new PlanBasico(0.00);
							break;

						case 2:
							plan = new PlanPlus(0.10);
							break;

						case 3:
							plan = new PlanPremium(0.20);
							break;

						default:
							plan = new PlanBasico(0.00);
					}

					Usuario nuevoUsuario = new Usuario(
							userId,
							nombre,
							saldo,
							nuevoVehiculo,
							plan);

					usuarios.add(nuevoUsuario);

					System.out.println("\nUsuario creado exitosamente.");

					break;

				case 6:

					System.out.println("\n=== HISTORIAL DE PEAJES ===");

					if (historialPeajes.isEmpty()) {
						System.out.println("No hay registros.");
					} else {
						for (int i = historialPeajes.size() - 1; i >= 0; i--) {
							System.out.println(historialPeajes.get(i));
						}
					}

					break;

				case 7:

					System.out.println("\n=== ELIMINAR USUARIO ===");

					if (usuarios.isEmpty()) {
						System.out.println("No hay usuarios registrados.");
						break;
					}

					for (int i = 0; i < usuarios.size(); i++) {
						System.out.println((i + 1) + ". "
								+ usuarios.get(i).getNombre()
								+ " | ID: "
								+ usuarios.get(i).getUserId());
					}

					System.out.print("Seleccione el usuario a eliminar: ");

					int indiceEliminar = solicitarNumero(sc) - 1;

					if (indiceEliminar >= 0 &&
							indiceEliminar < usuarios.size()) {
						Usuario eliminado = usuarios.remove(indiceEliminar);

						System.out.println(
								"Usuario "
										+ eliminado.getNombre()
										+ " eliminado correctamente.");
					} else {
						System.out.println("Usuario no válido.");
					}

					break;



				/*
				*en este espacio colocar el "case 8" para el update de la placa no olvidar
				*probar que solo se puedan ingresar datos validos
				*/



				case 9:

					System.out.println("Programa finalizado.");

					break;

				default:

					System.out.println("Opción inválida.");
			}

		} while (opcion != 9);

		sc.close();
	}
}
