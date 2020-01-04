#include <stdio.h>
#include <stdlib.h>

//link del video: https://youtu.be/KzbC_RBcfng

typedef struct nodo{
	int codigo;
	char nombre[20];
	int edad;
	int telefono;
    	struct nodo* sig;
	struct nodo* ant;
} nodo;

nodo* ini = NULL;
nodo* fin = NULL;

void insertar();
void buscar();
void modificar();
void eliminar();
void mostrarLista();


int main(){
	int opcionMenu = 0;
	do{
        	printf("\n-----------------------");
		printf("\n° AGENDA DE CONTACTOS °");
		printf("\n-----------------------");
		printf("\n 1. Insertar registro  ");
		printf("\n 2. Modificar registro ");
		printf("\n 3. Eliminar           ");
        	printf("\n 4. Mostrar contactos  ");
		printf("\n 5. Salir              ");
		printf("\n-----------------------");
		printf("\n\n Escoja una opcion: ");
		scanf("%d", &opcionMenu);

		switch(opcionMenu){
			case 1:
				printf("\n\n INSERTAR CONTACTO EN LA AGENDA \n\n");
				insertar();
				break;

			case 2:
				printf("\n\n MODIFICAR UN CONTACTO DE LA AGENDA \n\n");
				modificar();
				break;
			case 3:
				printf("\n\n ELIMINAR UN CONTACTO DE LA AGENDA \n\n");
				eliminar();
				break;
			case 4:
				printf("\n\n DESPLEGAR AGENDA DE CONTACTOS\n\n");
				mostrarLista();
				break;

			case 5:
				printf("\n\n Programa finalizado...");
				break;
			default:
				printf("\n\n Opcion no valida \n\n");
		}
	}while(opcionMenu != 5);
	return 0;
}


void insertar(){
	nodo* nuevo = (nodo*) malloc(sizeof(nodo));

	printf(" Ingrese el codigo del nuevo contacto: ");
	scanf("%d", &nuevo->codigo);
	printf(" Ingrese el nombre del nuevo contacto: ");
	scanf("%s",nuevo->nombre);
    	printf(" Ingrese la edad del nuevo contacto: ");
	scanf("%d",&nuevo->edad);
	printf(" Ingrese el telefono del nuevo contacto: ");
	scanf("%d",&nuevo->telefono);


	if(ini==NULL){
		ini = nuevo;
		ini->sig = NULL;
		ini->ant = NULL;
		fin = ini;
	}else{
		fin->sig = nuevo;
		nuevo->sig = NULL;
		nuevo->ant = fin;
		fin = nuevo;

	}
	printf("\n Contacto ingresado con exito\n\n");
}

void modificar(){
	nodo* actual = (nodo*) malloc(sizeof(nodo));
	actual = ini;
	int nodoBuscado = 0, encontrado = 0;
	printf(" Ingrese el codigo del nodo a buscar para modificar: ");
	scanf("%d", &nodoBuscado);

	if(ini!=NULL){
		while(actual != NULL && encontrado != 1){

			if(actual->codigo == nodoBuscado){
				printf("\n Contacto con el codigo ( %d ) encontrado", nodoBuscado);
				printf("\n Ingrese el nuevo codigo para este contacto: ");
				scanf("%d", &actual->codigo);
				printf("\n Ingrese el nuevo nombre para este contacto: ");
				scanf("%s", actual->nombre);
				printf("\n Ingrese la nueva edad para este contacto: ");
				scanf("%d", &actual->edad);
				printf("\n Ingrese el nuevo telefono para este contacto: ");
				scanf("%d", &actual->telefono);


				printf("\n Contacto modificado\n\n");
				encontrado = 1;
			}
			actual = actual->sig;
		}
		if(encontrado == 0){
			printf("\n Contacto no encontrado\n\n");
		}
	}else{
		printf("\n La agenda se encuentra vacia\n\n");
	}
}


void eliminar(){
	nodo* actual = (nodo*) malloc(sizeof(nodo));
	actual = ini;
	nodo* ant = (nodo*) malloc(sizeof(nodo));
	ant = NULL;
	int nodoBuscado = 0, encontrado = 0;
	printf(" Ingrese el codigo del contacto a buscar: ");
	scanf("%d", &nodoBuscado);

	if(ini!=NULL){
		while(actual != NULL && encontrado != 1){

			if(actual->codigo == nodoBuscado){
				printf("\n Contacto con el codigo ( %d ) encontrado", nodoBuscado);

				if(actual==ini){
					ini = ini->sig;
					ini->ant = NULL;
				}else if(actual==fin){
					ant->sig = NULL;
					fin = ant;
				}else{
					ant->sig = actual->sig;
					actual->sig->ant = ant;
				}
				printf("\n Contacto eliminado\n\n");
				encontrado = 1;
			}
			ant = actual;
			actual = actual->sig;
		}
		if(encontrado == 0){
			printf("\n Contacto no encontrado\n\n");
		}else{
			free(ant);
		}
	}else{
		printf("\n La agenda se encuentra vacia\n\n");
	}
}

void mostrarLista(){
	nodo* actual = (nodo*) malloc(sizeof(nodo));
	actual = ini;
	int numero = 1;
	if(ini!=NULL){
		while(actual != NULL){
            		printf("\n\n Contacto: %d", numero);
			printf("\n\t Codigo: %d", actual->codigo);
            		printf("\n\t Nombre: %s", actual->nombre);
            		printf("\n\t Edad: %d", actual->edad);
            		printf("\n\t Telefono: %d", actual->telefono);
            		numero++;
			actual = actual->sig;
		}
	}else{
		printf("\n La agenda se encuentra vacia\n\n");
	}
}
