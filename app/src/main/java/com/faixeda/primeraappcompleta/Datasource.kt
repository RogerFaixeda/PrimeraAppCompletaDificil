import com.faixeda.primeraappcompleta.AlumneViewModel

object Datasource {
    val alumnes = ArrayList<AlumneViewModel>()

    init {
        alumnes.add(AlumneViewModel("Jordi", 20, "SMX 1"))
        alumnes.add(AlumneViewModel("Dani", 21, "SMX 2"))
        alumnes.add(AlumneViewModel("Marcos", 22, "DAM 1"))
        alumnes.add(AlumneViewModel("Pepe", 23, "DAM 2"))
    }

    fun addAlumne(nom: String, edad: Int, curs: String) {
        alumnes.add(AlumneViewModel(nom, edad, curs))
    }


    fun getAlumneFromCurs(curs: String): ArrayList<AlumneViewModel> {
        val alumnespercurs = ArrayList<AlumneViewModel>()
        for (alumne in alumnes) {
            if (alumne.curs == curs) {
                alumnespercurs.add(alumne)
            }
        }
        return alumnespercurs
    }

}

