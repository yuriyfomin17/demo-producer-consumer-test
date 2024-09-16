package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("should return correct producer response")
    request {
        method GET()
        url("/producer/produce")
    }

    response {
        status(200)
        body("""
                {
                    "field1": 1,
                    "field2": 2,
                    "field3": 3
                }
            """)
        headers {
            contentType('application/json')
        }
    }
}
