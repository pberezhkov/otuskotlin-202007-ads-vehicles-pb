package ru.otus.otuskotlin.ads_vehicles.common.cor

class Processor<T> private constructor(
        private val matcher: CorMatcher<T>,
        private val handlers: Collection<IExec<T>>,
        private val errorHandler: CorErrorHandler<T>
): IExec<T> {
    override suspend fun exec(ctx: T): Unit {

    }

    class Builder<T> {
        private var matcher: CorMatcher<T> = { true }
        private var handlers: MutableList<IExec<T>> = mutableListOf()
        private var errorHandler: CorErrorHandler<T> = { throw it }

        fun isApplicable(block: CorMatcher<T>) {
            this.matcher = block
        }

        fun exec(handler: IExec<T>) = this.handlers.plus(handler)

        fun build(): Processor<T> {
            return Processor<T>(
                    matcher = matcher,
                    handlers = handlers,
                    errorHandler = errorHandler
            )
        }
    }
}