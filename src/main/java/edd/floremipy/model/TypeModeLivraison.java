package edd.floremipy.model;

public enum TypeModeLivraison {
	TRANSPORTEUR, POSTE, MAGASIN, CLIENT;

	@Override
	public String toString()
	{
		return super.toString().toUpperCase();
	}

	public static TypeModeLivraison getTypeModeLivraison(int idTypeModeLivraison){
		switch (idTypeModeLivraison) {
		case 0:
			return TypeModeLivraison.TRANSPORTEUR;

		case 1:
			return TypeModeLivraison.POSTE;

		case 2:
			return TypeModeLivraison.MAGASIN;

		case 3:
			return TypeModeLivraison.CLIENT;

		default:
			return TypeModeLivraison.MAGASIN;

		}
	}
}
