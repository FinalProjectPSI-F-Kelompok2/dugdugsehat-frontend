package ac.id.ub.filkom.dugdugsehat.Model

data class HealthResponse (
    val email: String? = null,
    val row: String? = null,
    val data: List<HealthEntry?> = listOf()
)
